/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilBCImple.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
 
package com.clt.apps.opus.esd.sce.common.util.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.sce.common.util.integration.CodeUtilDBDAO;
import com.clt.apps.opus.esd.sce.common.util.vo.CodeUtilVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * 
 * 
 * @author 
 * @see CodeUtilBC.java
 * @since J2EE 1.4
 */
public class CodeUtilBCImpl extends BasicCommandSupport implements CodeUtilBC {
	
	private transient CodeUtilDBDAO dao = null ;
	
	/**
	 * 
	 * Generate CodeUtilDAO.<br>
	 */
	public CodeUtilBCImpl(){
		dao = new CodeUtilDBDAO() ;
	}
	
	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @return String 
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, 
							   String valueField, String textField) throws EventException{
		return searchCodeCombo(selectName, table, valueField, textField, null, null, null) ;
	}
	
	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @param String orderByField
	 * @return String 
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField,
			                   String textField, String orderByField) throws EventException{
		return searchCodeCombo(selectName, table, valueField, textField, orderByField, null, null) ;
	}
	
	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @param String orderByField
	 * @param String options
	 * @return String 
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField,
			                   String textField, String orderByField, String options) throws EventException{
		return searchCodeCombo(selectName, table, valueField, textField, orderByField, options, null) ;
	}

	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @param String orderByField
	 * @param String options
	 * @param String addOption
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField,
			String textField, String orderByField, String options, String addOption) throws EventException{
		
		StringBuffer selectTag  = new StringBuffer() ;
		String[]     addOptions = addOption==null?null:addOption.split("#") ;
		DBRowSet     rowSet     = null;
		
		try{
			rowSet = dao.searchCodeCombo(table, valueField, textField, orderByField) ;
			selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +">\n") ;
			//2015.04.14 Critical Modify
			if(null != addOption){
				for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
					
					setAddOtptions(selectTag, addOptions, i) ;
					
					selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
					selectTag.append(rowSet.getString(2)) ;
					selectTag.append("</option>\n") ;
				}
			}
			selectTag.append("</select>") ;
		}	
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return selectTag.toString() ;
	}
	
	/**
     * 
     * @param String selectName
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField 
     * @param String orderByField
     * @param String options
     * @param String addOption
     * @return String 
     * @throws EventException
     */
    public String searchCodeCombo(String selectName, String table, String valueField,
            String textField,String whereField, String orderByField, String options, String addOption) throws EventException{

        StringBuffer selectTag  = new StringBuffer() ;
        String[]     addOptions = addOption==null?null:addOption.split("#") ;
        DBRowSet     rowSet     = null;
        
        try{
            rowSet = dao.searchCodeCombo(table, valueField, textField,whereField, orderByField) ;
            selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +"  onchange=\"comboChange()\">\n") ;
            //2015.04.14 Critical Modify
			if(null != addOption){
	            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
	                
	            	setAddOtptions(selectTag, addOptions, i) ;
	
	                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
	                selectTag.append(rowSet.getString(2)) ;
	                selectTag.append("</option>\n") ;
	            }
			}
            selectTag.append("</select>") ;
        }
        catch(SQLException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }
        catch(DAOException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }        
        catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
        
        return selectTag.toString() ;
    }
    
	/**
     * 
     * @param String selectName
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField 
     * @param String orderByField
     * @param String options
     * @param String addOption
     * @return String 
     * @throws EventException
     */
    public String searchCodeComboActual(String selectName, String table, String valueField,
            String textField,String whereField, String orderByField, String options, String addOption) throws EventException{

        StringBuffer selectTag  = new StringBuffer() ;
        String[]     addOptions = addOption==null?null:addOption.split("#") ;
        DBRowSet     rowSet     = null;
        CodeUtilVO vo = new CodeUtilVO();
        
        vo.setTablefield(table);
    	vo.setValuefield(valueField);
    	vo.setTextfield(textField);
    	vo.setWherefield(whereField);
    	vo.setOrderbyfield(orderByField);
        
        try{
        	
            rowSet = dao.searchCodeComboActual(vo);
            selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +"  onchange=\"comboChange()\">\n") ;
            //2015.04.14 Critical Modify
			if(null != addOption){
	            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
	                
	            	setAddOtptions(selectTag, addOptions, i) ;
	
	                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
	                selectTag.append(rowSet.getString(2)) ;
	                selectTag.append("</option>\n") ;
	            }
			}
            selectTag.append("</select>") ;
        }   
        catch(SQLException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }
        catch(DAOException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }        
        catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
        
        return selectTag.toString() ;
    }

	/**
     * 
     * @param String selectName
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField 
     * @param String orderByField
     * @param String options
     * @param String addOption
     * @return String 
     * @throws EventException
     */
    public String searchCodeComboRail(String selectName, String table, String valueField,
            String textField,String whereField, String orderByField, String options, String addOption) throws EventException{

        StringBuffer selectTag  = new StringBuffer() ;
        String[]     addOptions = addOption==null?null:addOption.split("#") ;
        DBRowSet     rowSet     = null;
        
        try{
            rowSet = dao.searchCodeCombo(table, valueField, textField,whereField, orderByField) ;
            selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +"  onchange=\"comboChange()\">\n") ;
            //2015.04.14 Critical Modify
			if(null != addOption){
	            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
	                
	            	setAddOtptions(selectTag, addOptions, i) ;
	
	            	if(rowSet.getString(1).equals("02") || rowSet.getString(1).equals("05")){
		
		                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
		                selectTag.append(rowSet.getString(2)) ;
		                selectTag.append("</option>\n") ;
	            	}
	            }
			}
            selectTag.append("</select>") ;
        }    
        catch(SQLException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }
        catch(DAOException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }
        catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
        
        return selectTag.toString() ;
    }

    
	/**
	 * 코드명을 가져온다.<br>
	 * 
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String code
	 * @return String 
	 * @throws EventException<br>
	 */
	public String searchCodeName(String table, String codeField, String nameField, String code)
	 							throws EventException{
		String codeName = null ;
		
		DBRowSet     rowSet     = null;
		
		try{
			rowSet = dao.searchCodeName(table, codeField, nameField, code) ;
			if(rowSet!=null && rowSet.next()){
				codeName = rowSet.getString(nameField) ;
			}
			
		}	
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return codeName ; 
	}
	
	
	/**
	 * Code / code-named list to look up..<br>
	 * 
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return RequestDataSetBC
	 * @throws EventException<br>
	 */
	public RequestDataSetBC searchCodeNameList(String table, String codeField, String 
											nameField, String whereField) throws EventException{
		RequestDataSetBC dataSet = RequestDataSetBC.getInstance() ;
		DBRowSet         rowSet  = null;
		
		try{
			rowSet = dao.searchCodeCombo(table, codeField, nameField, whereField, null);
			while(rowSet!=null && rowSet.next()){
				dataSet.add("code", rowSet.getString(1)) ;
				dataSet.add("name", rowSet.getString(2)) ;
			}
			
		}
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return dataSet ; 
	}
	
	/**
	 * 
	 * @param ComVvdManagementVO comVvdManagementVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	/*
	public List<CodeUtilVO> searchCodeNameListString(CodeUtilVO codeUtilVO) throws EventException {
		try {
			return dao.searchCodeCombo(codeUtilVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	*/
	/**
	 * Code / code-named list to look up.<br>
	 * 
	 * @param String dist
	 * @param String sltcd
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return String
	 * @throws EventException<br>
	 */
	public String searchCodeNameListString(String dist, String sltcd, String table, String codeField, String 
											nameField, String whereField) throws EventException{
		DBRowSet         rowSet  = null;
		StringBuffer result = new StringBuffer() ;
		int rstcnt = 0;
		String chkString = "";
		String [] exptRsnArray  = new String[0];
		
		log.debug("\n searchCodeNameListString :: sltcd:"+sltcd);
		try{
			rowSet = dao.searchCodeCombo(table, codeField, nameField, whereField, null);
			if(!sltcd.equals("")){
				exptRsnArray = sltcd.split(",");				
			}
			
			while(rowSet!=null && rowSet.next()){
				chkString = "";
				if(!sltcd.equals("")){
					for(int j = 0 ; j < exptRsnArray.length ; j++){
						if(rowSet.getString(1).equals(exptRsnArray[j])){
							chkString = "checked";
							j = exptRsnArray.length;
						}else{
							chkString = "";
						}
					}		
				}else{
					chkString = rowSet.getString(1).equals(sltcd)?"checked":"";
				}
				
				//log.debug("\n =========chkString:"+chkString);
				//dist="expt_rsn_inq":"expt_rsn"  
				result.append("<td width='17%' class='stm'><input name='"+dist+"' type='checkbox' "+chkString+" value='"+rowSet.getString(1)+";"+rowSet.getString(2)+"' class='trans'  onClick='"+("expt_rsn_inq".equals(dist)?"chkExptRsn(this)":"chkExptRsnIns(this)")+"'>&nbsp;"+rowSet.getString(2)+"</td>");
				rstcnt++;
				if(rstcnt%3==0){
					result.append("</tr><tr>");					
				}

			}
			
			result.append("</tr>");		
			log.debug("\n [checkbox]"+result.toString());
			
		}	
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return result.toString() ; 
	}
	
	/**
	 * Code / code-named list to look up. Sand-mail when importing contents&&&<br>
	 * 
	 * @param String dist
	 * @param String sltcd
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return String
	 * @throws EventException<br>
	 */
	public String searchCodeNameListContents(String dist, String sltcd, String table, String codeField, String 
											nameField, String whereField) throws EventException{
		DBRowSet         rowSet  = null;
		StringBuffer result = new StringBuffer() ;
		log.debug("\n searchCodeNameListString :: sltcd:"+sltcd+" ::dist"+dist);
		try{
			rowSet = dao.searchCodeCombo(table, codeField, nameField, whereField, null);
			while(rowSet!=null && rowSet.next()){
				if((rowSet.getString(1).equals("") )|| (rowSet.getString(1).length()==0)){
					result.append(rowSet.getString(1));	
				}else{
					result.append(rowSet.getString(1)+";");		
				}
			}

		}	
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return result.toString() ; 
	}
	
	
	/**
	 * Code Name List brings a js variable to store.<br>
	 * 
	 * @param boolean codeIdxFlag
	 * @param String variable
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return String
	 * @throws EventException<br>
	 */
	public String searchCodeNameListJsArray(boolean codeIdxFlag, String variable, String table, String codeField, String 
											nameField, String whereField) throws EventException{
		DBRowSet     rowSet = null;
		StringBuffer result = new StringBuffer() ;
		
		try{
			rowSet = dao.searchCodeCombo(table, codeField, nameField, whereField, null);
			
			result.append("var " + variable + " = new Array() ; \n");
			for(int i=0; rowSet!=null && rowSet.next(); i++){
				result.append(variable + "[" + (codeIdxFlag?"'"+rowSet.getString(1)+"'":i+"") + "] = '" + rowSet.getString(2) + "' ; \n") ;
			}
			
		}	
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return result.toString() ; 
	}
	
	
	/**
	 * Common code of the code / code-named list brings.<p>
	 * 
	 * @param String subCode
	 * @return RequestDataSetBC
	 * @throws EventException<br>
	 */
	/*public RequestDataSetBC searchCommonCodeNameList(String subCode) throws EventException{
		RequestDataSetBC dataSet = RequestDataSetBC.getInstance() ;
		DBRowSet         rowSet  = null;
		
		try{
			rowSet = dao.searchCommonCodeNameList(subCode) ;
			while(rowSet!=null && rowSet.next()){
				dataSet.add("code", rowSet.getString("intg_cd_val_ctnt")) ;
				dataSet.add("name", rowSet.getString("intg_Cd_val_dp_desc")) ;
			}
		}	
		catch(SQLException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch(DAOException e){
			log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
		}
		catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
		
		return dataSet ; 
	}*/
	
	/**
	 * Common code of the code / code-named list brings.<p>
	 * 
	 * @param RequestDataSetBC codeList
	 * @param String code
	 * @return String
	 * @throws EventException<br>
	 */
	public String searchCommonCodeName(RequestDataSetBC codeList, String code)
	 		throws EventException {
		String  name = "" ;
		
		for(int i=0; codeList!=null && i<codeList.getParameterLength("code"); i++){
			
			if(codeList.getString("code", i).equals(code)){
				name = codeList.getString("name", i);
				break ;
			}
		}
		
		return name ;
	}
	
	/**
     * 
     * @param String variable
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField 
     * @param String orderByField
     * @return String
	 * @throws EventException<br>
     */
	public String searchCodeComboSheet(String variable, String table, String valueField, String textField, 
									String whereField, String orderByField) throws EventException{
		StringBuffer resultText = new StringBuffer() ;
		StringBuffer resultCode = new StringBuffer() ;
		DBRowSet     rowSet = null ;
		
		try{
            rowSet = dao.searchCodeCombo(table, valueField, textField, whereField, orderByField) ;
            
            resultText.append("var " + variable + "Text = '") ;
            resultCode.append("var " + variable + "Code = '") ;
            
            for(int i=0; rowSet!=null && rowSet.next(); i++){
            	if(i>0){
            		resultText.append("|" + rowSet.getString(2)) ;
            		resultCode.append("|" + rowSet.getString(1)) ;
            	}
            	else{
            		resultText.append(rowSet.getString(2)) ;
            		resultCode.append(rowSet.getString(1)) ;
            	}
            }
            resultText.append("';\n") ;
            resultCode.append("';\n") ;
        }
        catch(SQLException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }
        catch(DAOException e){
            log.error(e.getMessage(), e);
            throw new EventException(e.getMessage());
        }
        catch (Exception e) {
			log.error(e.toString(), e);
			throw new EventException(e.getMessage());
		} 
        
		return resultText.toString() + resultCode.toString() ;
	}
	
	/**
	 * 
	 * @param StringBuffer selectTag
	 * @param String[] addOptions
	 * @param int idx
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
	
	/**
	 * @param HashMap map 
	 * @throws EventException
	 * 
	 */
	/*public void modifyBkgIf( HashMap map ) throws EventException{
		
		if( map != null ){
			
			String strbthtype 		= map.get("batch_type").toString();
			String strbkg_no 		= map.get("bkg_no").toString();
			String strbkg_no_split 	= map.get("bkg_no_split").toString();
			String strrcvdt 		= map.get("bkg_rcv_dt").toString();
			String strrcvno 		= map.get("bkg_rcv_no").toString();
			
			if( strbthtype.equals("min") ){
				
				try {
					dao.bkgif_minB_Upcoa(strbkg_no, strbkg_no_split );
				} catch (DAOException e) {
		            log.error(e.getMessage(), e);
		            throw new EventException(e.getMessage());
				}
				
			}else if ( strbthtype.equals("day") ){
				
				try {
					dao.bkgif_dayB_Upcoa( strrcvdt, strrcvno );
				} catch (DAOException e) {
		            log.error(e.getMessage(), e);
		            throw new EventException(e.getMessage());
				}
			}
		}
	}*/
	
	
	/**
	 * @param inbkg_no
	 * @param inbkg_no_split
	 * @param in_con
	 * @throws EventException
	 */
	/*public void modifyRailChk( String inbkg_no, String inbkg_no_split, Connection in_con ) throws EventException{
		
		if( in_con != null ){
			
			try {
				dao.modifyRailChk(inbkg_no, inbkg_no_split, in_con );
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new EventException(e.getMessage());
			}
		}
	}*/

	/**
	 * @param incop_no
	 * @param in_con
	 * @throws EventException
	 */
	/*public void modifyRailChk( String incop_no, Connection in_con ) throws EventException{
		
		if( in_con != null ){
			
			try {
				dao.modifyRailChk(incop_no, in_con );
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new EventException(e.getMessage());
			}
		}
	}*/
	
	/**
	 * @param cop_no
	 * @param unmatchedCode
	 * @throws EventException
	 */
//	public void modifyUnmatchedReason( String cop_no, String unmatchedCode) throws EventException{
//		
//		if( cop_no != null ){
//			
//			try {
//				dao.modifyUnmatchedReason(cop_no, unmatchedCode);
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new EventException(e.getMessage());
//			}
//		}
//	}
	
    /**
     * COP History Setting;<br>
     * @param String cop_no
     * @param String event_cd
     * @param String ofc_cd
     * @param String usr_id
     * @param String cmmt_yn
     * @return String
     * @throws EventException
     */
	public String  addSceCopHistory(String cop_no, String event_cd, String ofc_cd, String usr_id, String cmmt_yn) throws EventException {
		
		String retVal = "";
		if( cop_no != null ){
			
			try {
				retVal = dao.addSceCopHistory(cop_no, event_cd,ofc_cd,usr_id,cmmt_yn);
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new EventException(e.getMessage());
			}
		}
		
		return retVal;
	}	

	   /**
	 * ExptMst Table cancel
	 * @return 
	 * @throws DAOException
	 */
//	public int modifyExptMst(String copNo, String usrId) throws DAOException {
//		int result = 0;
//		if( copNo != null ){
//			
//			try {
//				result = dao.modifyExptMst( copNo,  usrId);
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new DAOException(new ErrorHandler(e).getMessage());
//			}
//		}		
//		return result;
//	}		
	
	/**
	 * SCE_EXPT_MST table status changed to cancel the value of (cop unit)
	 * @param copNo
	 * @return
	 * @throws DAOException
	 */
	public int cancelExptMst(String copNo) throws DAOException {
		int result = 0;
		if( copNo != null ){
			
			try {
				result = dao.cancelExptMst(copNo);
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
		}		
		return result;
	}		
	
	/** SCE_COP_HDR Table modify 
	 * @param copNo
	 * @throws EventException
	 */
	/*public void modifyItchgCtnt(String copNo) throws EventException {

		if( copNo != null ){
			
			try {
				dao.modifyItchgCtnt(copNo);
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new EventException(e.getMessage());
			}
		}		

	}*/		

	/** SCE_COP_HDR Table modify 
	 * @param soOfc
	 * @param soSeq
	 * @throws EventException
	 */
	/*public void modifyItchgCtnt(String soOfc, String soSeq) throws EventException {

		if( soOfc != null && soSeq != null ){
			
			try {
				dao.modifyItchgCtnt(soOfc, soSeq);
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new EventException(e.getMessage());
			}
		}		

	}*/		

	/** SCE_COP_HDR Table modify 
	 * @param rcvDt
	 * @param rcvNo
	 * @throws EventException
	 */
	/*public void modifyItchgCtntBkgIf(String rcvDt, String rcvNo) throws EventException {

		if( rcvDt != null && rcvNo != null ){
			
			try {
				dao.modifyItchgCtntBkgIf(rcvDt, rcvNo);
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new EventException(e.getMessage());
			}
		}		

	}*/		
	

}
