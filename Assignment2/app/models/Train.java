package models;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:45 PM
 * @description: ${description}
 */
public class Train extends GetWay {

    @Override
    public StringBuffer appenWay(City cfrom, City cto, StringBuffer str) {
        return str.append(cfrom.getName() + " To " + cto.getName() + " By Train, \n ");
    }

}
