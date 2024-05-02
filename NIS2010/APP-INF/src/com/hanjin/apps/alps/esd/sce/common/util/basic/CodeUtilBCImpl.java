/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilBCImple.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util 구현 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초 생성
* 2009-04-06 Jeong-seon An [N200903200140]   [SCEM] COP Header 로직 보완: OB_ITCHG_CTNT,IB_ITCHG_CTNT 컬럼 modify
* 2011-07-04 채창호 [CHM-201111830]:Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 
* 2011-07-07 채창호 [CHM-201111381-01]: Dwell Notification Management 신규개발 요청.
* 2012-04-27 채창호 [CHM-201217464-01]:SCEM(Customer EDI) upgrade project 관련 화면 수정 요청(1)
=========================================================*/
 
package com.hanjin.apps.alps.esd.sce.common.util.basic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.event.PricommonEvent;
import com.hanjin.apps.alps.esd.sce.common.util.vo.RsltCdListVO;

import com.hanjin.apps.alps.esd.sce.common.util.integration.CodeUtilDBDAO;
import com.hanjin.apps.alps.esd.sce.common.util.vo.CodeUtilVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * 코드 성격의 데이터를 가져오는 Util BC
 * 
 * @author Seong-mun Kang
 * @see CodeUtilBC.java
 * @since J2EE 1.4
 */
public class CodeUtilBCImpl extends BasicCommandSupport implements CodeUtilBC {
	
	private transient CodeUtilDBDAO dao = null ;
	
	/**
	 * 생성자
	 * CodeUtilDAO를 생성한다.<br>
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
			
			for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
				
				setAddOtptions(selectTag, addOptions, i) ;
				
				selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
				selectTag.append(rowSet.getString(2)) ;
				selectTag.append("</option>\n") ;
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
            
            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
                
            	setAddOtptions(selectTag, addOptions, i) ;

                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
                selectTag.append(rowSet.getString(2)) ;
                selectTag.append("</option>\n") ;
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
            
            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
                
            	setAddOtptions(selectTag, addOptions, i) ;

                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
                selectTag.append(rowSet.getString(2)) ;
                selectTag.append("</option>\n") ;
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

//	/**
//     * 
//     * @param String selectName
//     * @param String table
//     * @param String valueField
//     * @param String textField
//     * @param String whereField 
//     * @param String orderByField
//     * @param String options
//     * @param String addOption
//     * @return String 
//     * @throws EventException
//     */
//    public String searchCodeComboRail(String selectName, String table, String valueField,
//            String textField,String whereField, String orderByField, String options, String addOption) throws EventException{
//
//        StringBuffer selectTag  = new StringBuffer() ;
//        String[]     addOptions = addOption==null?null:addOption.split("#") ;
//        DBRowSet     rowSet     = null;
//        
//        try{
//            rowSet = dao.searchCodeCombo(table, valueField, textField,whereField, orderByField) ;
//            selectTag.append("<select name=\"" + selectName + "\" "+ (options==null?"":options) +"  onchange=\"comboChange()\">\n") ;
//            
//            for(int i=100010; rowSet!=null && rowSet.next(); i+=10){
//                
//            	setAddOtptions(selectTag, addOptions, i) ;
//
//            	if(rowSet.getString(1).equals("02") || rowSet.getString(1).equals("05")){
//	
//	                selectTag.append("    <option value=\"" + rowSet.getString(1) +"\">\n") ;
//	                selectTag.append(rowSet.getString(2)) ;
//	                selectTag.append("</option>\n") ;
//            	}
//            }
//            selectTag.append("</select>") ;
//        }    
//        catch(SQLException e){
//            log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//        }
//        catch(DAOException e){
//            log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//        }
//        catch (Exception e) {
//			log.error(e.toString(), e);
//			throw new EventException(e.getMessage());
//		} 
//        
//        return selectTag.toString() ;
//    }

    
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
	
	
//	/**
//	 * 코드/코드명 리스트을 가져온다.<br>
//	 * 
//	 * @param String table
//	 * @param String codeField
//	 * @param String nameField
//	 * @param String whereField
//	 * @return RequestDataSetBC
//	 * @throws EventException<br>
//	 */
//	public RequestDataSetBC searchCodeNameList(String table, String codeField, String 
//											nameField, String whereField) throws EventException{
//		RequestDataSetBC dataSet = RequestDataSetBC.getInstance() ;
//		DBRowSet         rowSet  = null;
//		
//		try{
//			rowSet = dao.searchCodeCombo(table, codeField, nameField, whereField, null);
//			while(rowSet!=null && rowSet.next()){
//				dataSet.add("code", rowSet.getString(1)) ;
//				dataSet.add("name", rowSet.getString(2)) ;
//			}
//			
//		}
//		catch(SQLException e){
//			log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//		}
//		catch(DAOException e){
//			log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//		}
//		catch (Exception e) {
//			log.error(e.toString(), e);
//			throw new EventException(e.getMessage());
//		} 
//		
//		return dataSet ; 
//	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * 코드/코드명 리스트을 가져온다.<br>
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
	
//	/**
//	 * 코드/코드명 리스트을 가져온다. 메일샌드시 contents가져오기&&&<br>
//	 * 
//	 * @param String dist
//	 * @param String sltcd
//	 * @param String table
//	 * @param String codeField
//	 * @param String nameField
//	 * @param String whereField
//	 * @return String
//	 * @throws EventException<br>
//	 */
//	public String searchCodeNameListContents(String dist, String sltcd, String table, String codeField, String 
//											nameField, String whereField) throws EventException{
//		DBRowSet         rowSet  = null;
//		StringBuffer result = new StringBuffer() ;
//		log.debug("\n searchCodeNameListString :: sltcd:"+sltcd+" ::dist"+dist);
//		try{
//			rowSet = dao.searchCodeCombo(table, codeField, nameField, whereField, null);
//			while(rowSet!=null && rowSet.next()){
//				if((rowSet.getString(1).equals("") )|| (rowSet.getString(1).length()==0)){
//					result.append(rowSet.getString(1));	
//				}else{
//					result.append(rowSet.getString(1)+";");		
//				}
//			}
//
//		}	
//		catch(SQLException e){
//			log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//		}
//		catch(DAOException e){
//			log.error(e.getMessage(), e);
//            throw new EventException(e.getMessage());
//		}
//		catch (Exception e) {
//			log.error(e.toString(), e);
//			throw new EventException(e.getMessage());
//		} 
//		
//		return result.toString() ; 
//	}
	
	
	/**
	 * 코드명 리스트를 js 변수로 저장해서 가져온다.<br>
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
	
//	/**
//	 * @param HashMap map 
//	 * @throws EventException
//	 * 
//	 */
//	public void modifyBkgIf( HashMap map ) throws EventException{
//		
//		if( map != null ){
//			
//			String strbthtype 		= map.get("batch_type").toString();
//			String strbkg_no 		= map.get("bkg_no").toString();
//			String strbkg_no_split 	= map.get("bkg_no_split").toString();
//			String strrcvdt 		= map.get("bkg_rcv_dt").toString();
//			String strrcvno 		= map.get("bkg_rcv_no").toString();
//			
//			if( strbthtype.equals("min") ){
//				
//				try {
//					dao.bkgif_minB_Upcoa(strbkg_no, strbkg_no_split );
//				} catch (DAOException e) {
//		            log.error(e.getMessage(), e);
//		            throw new EventException(e.getMessage());
//				}
//				
//			}else if ( strbthtype.equals("day") ){
//				
//				try {
//					dao.bkgif_dayB_Upcoa( strrcvdt, strrcvno );
//				} catch (DAOException e) {
//		            log.error(e.getMessage(), e);
//		            throw new EventException(e.getMessage());
//				}
//			}
//		}
//	}
	
	
//	/**
//	 * @param inbkg_no
//	 * @param inbkg_no_split
//	 * @param in_con
//	 * @throws EventException
//	 */
//	public void modifyRailChk( String inbkg_no, String inbkg_no_split, Connection in_con ) throws EventException{
//		
//		if( in_con != null ){
//			
//			try {
//				dao.modifyRailChk(inbkg_no, inbkg_no_split, in_con );
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new EventException(e.getMessage());
//			}
//		}
//	}

//	/**
//	 * @param incop_no
//	 * @param in_con
//	 * @throws EventException
//	 */
//	public void modifyRailChk( String incop_no, Connection in_con ) throws EventException{
//		
//		if( in_con != null ){
//			
//			try {
//				dao.modifyRailChk(incop_no, in_con );
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
	 * ExptMst 테이블 cancel
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
	 * S/C No prefix List 콤보를 조회합니다.<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchScPrefixList() throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	StringBuffer sbText = new StringBuffer();
		StringBuffer sbValue = new StringBuffer();
		List totalList = new ArrayList();  
		RsltCdListVO rsltCdlistVo = new RsltCdListVO();
        try{
        	
            List<RsltCdListVO> list = dao.searchScPrefixList(rsltCdlistVo);
                    
            Iterator iterator = list.iterator();
    		while (iterator.hasNext()) {
    			RsltCdListVO codeModel = (RsltCdListVO) iterator.next();
    			totalList.add(codeModel);
    		}
    		
    		Iterator totalIterator = totalList.iterator();
    		RsltCdListVO codeModel = null;

    		if (totalIterator.hasNext()) {
    			codeModel = (RsltCdListVO) totalIterator.next();
    			sbText.append("var ").append("sc").append("Text").append(" = \"");
    			sbText.append(codeModel.getNm());
    			sbValue.append("var ").append("sc").append("Code").append(" = \"");
    			sbValue.append(codeModel.getCd());
    			//sbSelected.append("var ").append(tagName).append("Selected").append(" = \"");
    			//sbSelected.append(sSelectedCode);
    		}

    		while (totalIterator.hasNext()) {
    			codeModel = (RsltCdListVO) totalIterator.next();
    			sbText.append("|");
    			sbText.append(codeModel.getNm());
    			sbValue.append("|");
    			sbValue.append(codeModel.getCd());
    		}

    		if (sbText.length() > 0) {
    			sbText.append("\";");
    			sbValue.append("\";");
    		}

        }catch (DAOException e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage()); // SCE MESSAGE로 변경
        }
        return sbText.append("\n").append(sbValue).toString();
	}
	
	
	/**
	 * Sting문자를 입력받아 ","구분자로 잘라 List의 형태로 반환.
	 * 
	 * @param str String
	 * @return List<String>
	 */
	public List<String> replaceStrToList(String str) {
		ArrayList<String>  array = new ArrayList<String>();
		
		StringTokenizer tokenTpszcd = new StringTokenizer(str, ",");
		
		while (tokenTpszcd.hasMoreTokens()) {
			array.add(tokenTpszcd.nextToken());
		}
		
		return array;
	}

	/**
	 * Sting문자를 입력받아 ","구분자로 자르고 해당 문자를 ''로 감싼 형태로 다시 반환.
	 * 
	 * @param str String
	 * @return String
	 */
	public  String convertStr(String str) {		
		return convertStr(str , false , 0);
	}
	
	/**
	 * Sting문자를 입력받아 ","구분자로 자르고 해당 문자를 ''로 감싼 형태로 다시 반환.
	 * 
	 * @param str String
	 * @param DefaultCheck boolean
	 * @param int length
	 * @return String
	 */
	public static String convertStr(String str , boolean DefaultCheck , int length) {
		StringBuffer buffer = new StringBuffer(512);
		StringTokenizer tokenTpszcd = new StringTokenizer(str, ",");
		int strSize = tokenTpszcd.countTokens();
		while (tokenTpszcd.hasMoreTokens()) {
			strSize--;
			String addStr = tokenTpszcd.nextToken();
			if(length != 0 && addStr != null && addStr.length() >= length){
				addStr = addStr.substring(0, length);
			}
			buffer.append("'" + addStr + "'");
			if (strSize != 0){
				buffer.append(",");
			}
		}
		// in 절에 sql 에러를 막기위한 조건
		if(buffer.toString().equals("") && DefaultCheck){
			buffer.append("''");
		}
		return buffer.toString();
	}
//	/** SCE_COP_HDR 테이블 modify 
//	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
//	 * @param copNo
//	 * @throws EventException
//	 */
//	public void modifyItchgCtnt(String copNo) throws EventException {
//
//		if( copNo != null ){
//			
//			try {
//				dao.modifyItchgCtnt(copNo);
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new EventException(e.getMessage());
//			}
//		}		
//
//	}		

//	/** SCE_COP_HDR 테이블 modify 
//	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
//	 * @param soOfc
//	 * @param soSeq
//	 * @throws EventException
//	 */
//	public void modifyItchgCtnt(String soOfc, String soSeq) throws EventException {
//
//		if( soOfc != null && soSeq != null ){
//			
//			try {
//				dao.modifyItchgCtnt(soOfc, soSeq);
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new EventException(e.getMessage());
//			}
//		}		
//
//	}		

//	/** SCE_COP_HDR 테이블 modify 
//	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
//	 * @param rcvDt
//	 * @param rcvNo
//	 * @throws EventException
//	 */
//	public void modifyItchgCtntBkgIf(String rcvDt, String rcvNo) throws EventException {
//
//		if( rcvDt != null && rcvNo != null ){
//			
//			try {
//				dao.modifyItchgCtntBkgIf(rcvDt, rcvNo);
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new EventException(e.getMessage());
//			}
//		}		
//
//	}		
	
//	/**
//	 * Exception발생 prc호출.
//	 * @return 
//	 * @throws DAOException
//	 */
//	public String  setCopExptResistAct(String cop_no, String usr_id ,String cmmt_yn) throws DAOException {
//		
//		String result = "";
//		if( cop_no != null ){ 
//			
//			try {
//				result = dao.setCopExptResistAct(cop_no, usr_id, cmmt_yn);
//			} catch (DAOException e) {
//				log.error(e.getMessage(), e);
//				throw new DAOException(new ErrorHandler(e).getMessage());
//			}
//		}
//		
//		return result;
//	}

	/**
	 * @param ofc_cd
	 * @return
	 * @throws DAOException
	 */
	public int searchOfcInfo(String ofc_cd) throws DAOException {
		
		int retVal = 0;
			try {
				retVal = dao.searchOfcInfo(ofc_cd);
			} catch (DAOException e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			}
		
		return retVal;
	}

}
