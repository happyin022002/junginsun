/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilBCImple.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util 구현 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : Sang-mo Kim
*@LastVersion : 1.0
* 2006-10-02 Sang-mo Kim
* 1.0 최초 생성
=========================================================*/
 
package com.clt.apps.opus.esd.lea.common.codeutil.basic;


import com.clt.apps.opus.esd.lea.common.codeutil.integration.CodeUtilDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * 코드 성격의 데이터를 가져오는 Util BC
 * 
 * @author Sang-mo Kim
 * @see CodeUtilBC.java
 * @since J2EE 1.4
 */
public class CodeUtilBCImpl extends BasicCommandSupport implements CodeUtilBC {
	
	private transient CodeUtilDBDAO dbDaoAlps = null;
	private transient CodeUtilDBDAO dbDao = null;
	
	/**
	 * 생성자
	 * CodeUtilDBDAO를 생성한다.<br>
	 */
	public CodeUtilBCImpl(){
		dbDaoAlps = new CodeUtilDBDAO();
		dbDao = new CodeUtilDBDAO();
	}
	
//	/**
//	 * 
//	 * @param selectName select tag 명<br>
//	 * @param table 테이블명<br>
//	 * @param valueField value 필드명<br>
//	 * @param textField text 필드명<br>
//	 * 
//	 * @return selectTag<br> 
//	 */
//	public String getCodeCombo(String selectName, String table, 
//							   String valueField, String textField) throws EventException{
//		System.out.println("@@0");		
//		return getCodeCombo(selectName, table, valueField, textField, null, null, null) ;
//	}
//	
//	/**
//	 * 
//	 * @param selectName select tag 명<br>
//	 * @param table 테이블명<br>
//	 * @param valueField value 필드명<br>
//	 * @param textField text 필드명<br>
//	 * @param orderByField order by 필드명<br>
//	 * 
//	 * @return selectTag<br> 
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField,
//			                   String textField, String orderByField) throws EventException{
//		
//		System.out.println("@@1");
//		return getCodeCombo(selectName, table, valueField, textField, orderByField, null, null) ;
//	}
//	
//	/**
//	 * 
//	 * @param selectName select tag 명<br>
//	 * @param table 테이블명<br>
//	 * @param valueField value 필드명<br>
//	 * @param textField text 필드명<br>
//	 * @param orderByField order by 필드명<br>
//	 * @param options select 옵션<br>
//	 * 
//	 * @return selectTag<br> 
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField,
//			                   String textField, String orderByField, String options) throws EventException{
//		System.out.println("@@2");
//		return getCodeCombo(selectName, table, valueField, textField, orderByField, options, null) ;
//	}
//
//	/**
//	 * 
//	 * @param selectName select tag 명<br>
//	 * @param table 테이블명<br>
//	 * @param valueField value 필드명<br>
//	 * @param textField text 필드명<br>
//	 * @param orderByField 정렬 필드명<br>
//	 * @param options select 옵션<br>
//	 * @param addOption 추가 옵션<br>
//	 * 
//	 * @return selectTag <br>
//	 */
//	public String getCodeCombo(String selectName, String table, String valueField,
//			String textField, String orderByField, String options, String addOption) throws EventException{
//		System.out.println("@@3");
//		StringBuffer selectTag  = new StringBuffer() ;
//		String[]     addOptions = addOption==null?null:addOption.split("#") ;
//		DBRowSet     rowSet     = null;
//		
//		try{
//			rowSet = dbDao.getCodeCombo(table, valueField, textField, orderByField) ;
//			selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +">\n") ;
//			
//			for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
//				
//				setAddOtptions(selectTag, addOptions, i) ;
//				
//				selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
//				selectTag.append(rowSet.getString(2)) ;
//				selectTag.append("</option>\n") ;
//			}
//			selectTag.append("</select>") ;
//		}
//		catch(SQLException e){
//			log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//		}
//		catch(DAOException e){
//			log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//		}
//		
//		return selectTag.toString() ;
//	}
	
	/**
     * 
     * @param selectName select tag 명
     * @param table 테이블명
     * @param valueField value 필드명
     * @param textField text 필드명
     * @param whereField where option 
     * @param orderByField 정렬 필드명
     * @param options select 옵션
     * @param addOption 추가 옵션
     * @return selectTag 
     */
    public String getCodeCombo(String selectName, String table, String valueField,
            String textField, String whereField, String orderByField, String options, String addOption) throws EventException{
    	
        StringBuffer selectTag  = new StringBuffer() ;
        String[]     addOptions = addOption==null?null:addOption.split("#") ;

        DBRowSet     rowSet     = null;
        
        try{
        	if ( table.concat(" ").substring(0, 3).equalsIgnoreCase("lea")){
        		rowSet = dbDao.getCodeCombo(table, valueField, textField, whereField, orderByField) ;
        		
        	}else {
        		rowSet = dbDaoAlps.getCodeCombo(table, valueField, textField, whereField, orderByField) ;
        	}

            /* lea_com_enterKeyEvent('lea_enterRetrieve') : Retrieve Button Click과 동일한 기능 */
            selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +"  onKeyDown=\"lea_com_enterKeyEvent('lea_enterRetrieve')\">\n") ;
            
            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
                
            	setAddOtptions(selectTag, addOptions, i) ;

                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
                selectTag.append(rowSet.getString(1)) ;
                selectTag.append("</option>\n") ;
            }
            selectTag.append("</select>") ;
       
        
        } catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}

        return selectTag.toString() ;
    }

	/**
	 * 
	 * @param selectTag Select Tag
	 * @param addOptions 추가할 Option
	 * @param idx DB에서 가져온 options값의 sort index
	 */
	private void setAddOtptions(StringBuffer selectTag, String[] addOptions, int idx){
		String[] options = null ;
		
		if(addOptions!=null){
			for(int j=0; j<addOptions.length; j++){
				if(addOptions[j]!=null){
					options = addOptions[j].split(":") ;
					
					if(options!=null && Long.parseLong(options[0])<=idx){
						selectTag.append("    <option value=\"" + options[1] +"\">") ;
						selectTag.append(options[2]) ;
						selectTag.append("</option>\n") ;
						addOptions[j] = null ;
					}
				}
			}
		}
		
	}
	
}
