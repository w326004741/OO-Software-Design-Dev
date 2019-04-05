package controllers;

import java.util.HashMap;

import models.*;
import play.mvc.Controller;


/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:44 PM
 * @description: ${description}
 */
public class PlannerProcessor {

    public static StringBuffer findWay(int fid, int tid) {
        StringBuffer str = new StringBuffer();
        City cfrom = City.find("byCityId", Math.toIntExact(fid)).first();
        City cto = City.find("byCityId", Math.toIntExact(tid)).first();
        System.out.println("1: " + cfrom.getCountry().getName());
        System.out.println("2: " + cto.getCountry().getName());
        if (cfrom.getCountry().equals(cto.getCountry())) {//国内坐巴士
            Bus bus = new Bus();
            bus.appenWay(cfrom, cto, str);
            return str;
        } else {// two cities are not in same country 国外

            if (cfrom.getCountry().getNeighbor().get(cto.getCountry().getId()) != null) {// bordering country 边境国家
                //  if two cites are both capital of country then take a plane 两城都为首都直接坐飞机
                if (cfrom.equals(cfrom.getCountry().getCapital()) && cto.equals(cto.getCountry().getCapital())) {
                    Plane plane = new Plane();
                    plane.appenWay(cfrom, cto, str);
                } else {// two cities that has one city is capital and another is not 有一非首都则做火车
                    Train train = new Train();
                    train.appenWay(cfrom, cto, str);
                }
                return str;
            }
            // no bordering country 非边境
            if (cfrom.equals(cfrom.getCountry().getCapital())) {//出发点为首都直接坐飞机到目的地国家首都

                Plane plane = new Plane();
                plane.appenWay(cfrom, cto.getCountry().getCapital(), str);

            } else {//出发点非首都,先做公交去首都再坐飞机去目的地国家首都
                Bus bus = new Bus();
                bus.appenWay(cfrom, cfrom.getCountry().getCapital(), str);
                Plane plane = new Plane();
                plane.appenWay(cfrom.getCountry().getCapital(), cto.getCountry().getCapital(), str);

            }

            if (cto.equals(cto.getCountry().getCapital())) {//目的地城市为首都结束行程(destination city is capital)
                return str;
            } else { //目的地非首都 坐巴士去目的地
                Bus bus = new Bus();
                bus.appenWay(cto.getCountry().getCapital(), cto, str);
            }
        }
        return str;
    }

}
