/**
 * Created by ms-zk on 2017-04-12.
 */
function getRootPath(url){
    var strFullPath=window.document.location.href;
    var strPath=window.document.location.pathname;
    var pos=strFullPath.indexOf(strPath);
    var prePath=strFullPath.substring(0,pos);
    return prePath + '/' + url;
}
