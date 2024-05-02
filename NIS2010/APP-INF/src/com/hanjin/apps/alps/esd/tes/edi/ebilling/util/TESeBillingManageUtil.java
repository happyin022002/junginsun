/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingManageBCAbst.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012-01-04
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.util;


//import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
//import com.hanjin.apps.alps.esd.tes.common.tescommon.util.TESUtil;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManage01BCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBizType000BC;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBizType001BCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBizType002BCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBizType003BCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageBizType004BCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvFltFileXcldVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleMnVO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiRcvRuleVndrMgmtVO;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingManageBC 참조
 * @since J2EE 1.4
 */
public class TESeBillingManageUtil {

	/**
	 * log
	 */
	protected static Logger log = Logger.getLogger(TESeBillingManageUtil.class.getName());

	/**
	 * QUERY생성시 제외 대상인지 검사하여 대상인 경우 대상 COLUMN의 넣을 값을 return한다.
	 * 
	 * @param exc_cols_n_val
	 * @param col
	 * @return String 
	 */
	public static String checkExcColumn(String[][] exc_cols_n_val, String col) {
		if (exc_cols_n_val!=null && col!=null){
			for (int k=0; exc_cols_n_val!=null && k<exc_cols_n_val.length; k++){
				if (exc_cols_n_val[k][0]!=null && exc_cols_n_val[k][0].equals(col)){
					return exc_cols_n_val[k][1];
				}
			}
		}
		return null; // 일치값이 없을 경우는 반드시 null을 넘길것 - ""도 넘기면 안된당.
	}

	/**
	 * F/F의 첫번째 줄을 읽어 SRC S/P를 파악하여 분리한다.
	 * 일단 MSG 추출 자리수는 변경이 없다는 전제하에 작업한다. 혹시 변경이 되면 여길 바꾸는게 현재로써는 가장 현실적이며 굳이 DB화 할 필요가 아주 적어보임
	 * 
	 * $$$MSGSTART:(12 digit) + Sender ID(20 digit) + Receiver ID(20 digit) + Msg ID(10 digit) + Unique Seq.(20 digit)
	    sample1) $$$MSGSTART:HIT                 HJS                 INVOICE   UBIZ1:651698062     
		sample2) $$$MSGSTART:KHHCY01             HJCL                INVOIC
	 * 
	 * @param str_ffs
	 * @param tesEdiInitVO
	 * @throws EventException
	 */
	public static void getNSetEDIMsgInfo(String str_ffs, TesEdiSoHdrVO tesEdiInitVO) throws EventException {
		log.error("\n\n BEGIN - TESeBillingManageUtil - getNSetEDIMsgInfo() - ########################################### ");

		String sndr_id = null;
		String rcvr_id = null;
		String flt_file_msg_id = null;
		String first_line_text = null;
		String msg_line_tmp = null;
		
		try {
			if (str_ffs!=null && !str_ffs.trim().equals("")){
				str_ffs = str_ffs.trim();
				if (str_ffs.indexOf("\n")>0){
					msg_line_tmp = str_ffs.substring(0,str_ffs.indexOf("\n"));	
				} else {
					msg_line_tmp = str_ffs.substring(0,str_ffs.length());
				}
				msg_line_tmp = msg_line_tmp!=null&&!msg_line_tmp.trim().equals("")?(msg_line_tmp.trim().length()>82?msg_line_tmp.trim().substring(0,82):msg_line_tmp.trim()):"";
				if (msg_line_tmp!=null && !msg_line_tmp.trim().equals("")){
					if (msg_line_tmp.trim().startsWith("$$$MSGSTART")){
						sndr_id = msg_line_tmp.trim().length()>=32?msg_line_tmp.trim().substring(12,32).trim():(msg_line_tmp.trim().length()>=12?msg_line_tmp.trim().substring(12,msg_line_tmp.trim().length()):"");
						rcvr_id = msg_line_tmp.trim().length()>=52?msg_line_tmp.trim().substring(32,52).trim():(msg_line_tmp.trim().length()>=32?msg_line_tmp.trim().substring(32,msg_line_tmp.trim().length()):"");
						flt_file_msg_id = msg_line_tmp.trim().length()>=62?msg_line_tmp.trim().substring(61,msg_line_tmp.trim().length()).trim():"";
						first_line_text = msg_line_tmp.trim().substring(0,msg_line_tmp.trim().length()).trim();
						first_line_text = first_line_text!=null&&!first_line_text.trim().equals("")?(first_line_text.trim().length()>82?first_line_text.trim().substring(0,82):first_line_text.trim()):"";
						if (tesEdiInitVO!=null){
							tesEdiInitVO.setSndrId(sndr_id);
							tesEdiInitVO.setRcvrId(rcvr_id); 
							tesEdiInitVO.setFltFileMsgId(flt_file_msg_id);
							tesEdiInitVO.setEdiMsg(first_line_text);
						}					
					} else {
						log.error("\n Malformed EDI MSG found Exception!!! \n");
						throw new EventException("\n Malformed EDI MSG found Exception!!! \n");
					}
				}
			}
			log.debug("\n getEDISrcVndr() - SNDR: "+(sndr_id!=null&&!sndr_id.trim().equals("")?sndr_id:"")+"\n");
		} catch(Exception ex){
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		log.error("\n\n END - TESeBillingManageUtil - getNSetEDIMsgInfo() - ########################################### ");		
	}


	/**
	 * Invoice단위의 F/F에서 VNDR code를 추출
	 * 
	 * @param str_ffs
	 * @return
	 * @throws EventException
	 */
	public static void getSetEdiVndrCode(TesEdiSoHdrVO tesEdiInitVO, String str_ff) throws EventException { 
		log.error("\n\n TESeBillingManageUtil -->  BEGIN - getSetEdiVndrCode() - ########################################### ");

		String vndr_seq_tmp = null;
		int bInx = 0;
		int eInx = 0;
//		String tmp = null;
//		String[] str_arr = null;
		
		try {
			if (str_ff!=null && !str_ff.trim().equals("") && tesEdiInitVO!=null){
				str_ff = str_ff.trim();
				
				/** 1) **/
				if (str_ff.indexOf("\n"+TESeBillingCommonBC.FF_VNDR_SEQ_NM)!=-1 || str_ff.indexOf(TESeBillingCommonBC.FF_VNDR_SEQ_NM)!=-1){
					if (str_ff.indexOf("\n"+TESeBillingCommonBC.FF_VNDR_SEQ_NM)!=-1){
						bInx = str_ff.indexOf("\n"+TESeBillingCommonBC.FF_VNDR_SEQ_NM)+("\n"+TESeBillingCommonBC.FF_VNDR_SEQ_NM).length()+(":".length());
					} else if (str_ff.indexOf(TESeBillingCommonBC.FF_VNDR_SEQ_NM)!=-1){
						bInx = str_ff.indexOf(TESeBillingCommonBC.FF_VNDR_SEQ_NM)+(TESeBillingCommonBC.FF_VNDR_SEQ_NM).length()+(":".length());
					}
					eInx = bInx+TESeBillingCommonBC.FF_VNDR_SEQ_LENGTH;
					vndr_seq_tmp = str_ff.substring(bInx,eInx);
					tesEdiInitVO.setVndrSeq(JSPUtil.getNull(vndr_seq_tmp));
					log.debug("\n 1) vndr_seq_tmp:"+vndr_seq_tmp+"<<<<\n");
				}
				
				/** 2) **/
//				str_arr = TESUtil.getStringToArray(str_ff,"\n");
//				if (str_arr!=null && str_arr.length>0){
//					for (int s=0; str_arr!=null && s<str_arr.length; s++){
//						if (str_arr[s]!=null && !str_arr[s].trim().equals("")){
//							if (str_arr[s].trim().startsWith(TESeBillingCommonBC.FF_VNDR_SEQ_NM)){
//								vndr_seq_tmp = str_arr[s].trim().substring(str_arr[s].trim().indexOf(":")+1).trim();
//								vndr_seq_tmp = (vndr_seq_tmp.trim().length()>6?vndr_seq_tmp.trim().substring(1,6):vndr_seq_tmp.trim());
//								log.debug("\n ["+s+"] VNDR_SEQ value:"+(JSPUtil.getNull(vndr_seq_tmp))+" \n");
//								tesEdiInitVO.setVndrSeq(JSPUtil.getNull(vndr_seq_tmp));
//								break;
//							}
//						}
//					}
//				}
				
			}
			log.debug("\n getSetEdiVndrCode()-VNDR seq: "+(tesEdiInitVO!=null?(tesEdiInitVO.getVndrSeq()!=null&&!tesEdiInitVO.getVndrSeq().trim().equals("")?tesEdiInitVO.getVndrSeq().trim():""):"")+"\n");
		} catch(Exception ex){
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		log.error("\n\n TESeBillingManageUtil -->  END - getSetEdiVndrCode() - ########################################### ");
	}

	/**
	 * F/F의 열고 닫는 TAG의 유효성 확인
	 * '{~' 나 '}~'로 열고 닫으면 무조건 전수 검사할지 지정된 INVOICE TAG만 우선 검사할지 EDI RULE에서 값을 받아 분기 처리한다. 
	 * 
	 * 
	 * @param str_ffs
	 * @param tesEdiRuleMainVO
	 * @return
	 * @throws EventException
	 */
	public static boolean checkTagValidation(String str_ffs, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) throws EventException {
		log.debug("\n TESeBillingManageUtil-checkTagValidation~~~~~ \n");
		
		boolean isValidTag = false;
		java.io.BufferedReader br = null;
		java.io.StringReader sr = null;
		String buffer = null;
		Stack<String> st = null;
		String inv_tag_nm = null;
		String pop_tag_nm = null;
		
		try {
			if (str_ffs!=null && !str_ffs.trim().equals("")){
				if (tesEdiRuleMainVO!=null){
					tesEdiRuleMainVO.getInitAllTagValChkFlg();
					tesEdiRuleMainVO.getInitInvTagValChkFlg();
					if ((tesEdiRuleMainVO.getInitAllTagValChkFlg()!=null && tesEdiRuleMainVO.getInitAllTagValChkFlg().trim().equals("Y")) 
						||
						(tesEdiRuleMainVO.getInitInvTagValChkFlg()!=null && tesEdiRuleMainVO.getInitInvTagValChkFlg().trim().equals("Y")))
					{
						sr = new java.io.StringReader(str_ffs);
						br = new java.io.BufferedReader(sr);
						inv_tag_nm = tesEdiRuleMainVO.getInvTagNm();
						if (br!=null){
							st = new Stack<String>();
							if (st!=null){
								while ((buffer=br.readLine())!=null){
									if (buffer!=null && !buffer.trim().equals("")){
										if (buffer.trim().startsWith("{")){
											isValidTag = false;
											if (tesEdiRuleMainVO.getInitInvTagValChkFlg()!=null && tesEdiRuleMainVO.getInitInvTagValChkFlg().trim().equals("Y")){
												if (inv_tag_nm!=null && !inv_tag_nm.trim().equals("") && buffer.trim().equals("{"+inv_tag_nm.trim())) {
													st.push(buffer.trim());
												}
											} else {
												st.push(buffer.trim());
											}
										} else if (buffer.trim().startsWith("}")){
											if (tesEdiRuleMainVO.getInitInvTagValChkFlg()!=null && tesEdiRuleMainVO.getInitInvTagValChkFlg().trim().equals("Y")){
												if (inv_tag_nm!=null && !inv_tag_nm.trim().equals("") && buffer.trim().equals("}"+inv_tag_nm.trim())) {
													if (!st.isEmpty()){
														pop_tag_nm = st.pop();	
													}
													if (pop_tag_nm!=null && !pop_tag_nm.trim().equals("")){
														pop_tag_nm = JSPUtil.replace(pop_tag_nm.trim(),"{","}");
														if (pop_tag_nm.trim().equals(buffer.trim())){
															isValidTag = true;
														} else {
															isValidTag = false;
															break;
														}
													} else {
														isValidTag = false;
														break;
													}
												}
											} else {
												if (!st.isEmpty()){
													pop_tag_nm = st.pop();	
												}
												if (pop_tag_nm!=null && !pop_tag_nm.trim().equals("")){
													pop_tag_nm = JSPUtil.replace(pop_tag_nm.trim(),"{","}");
													if (pop_tag_nm.trim().equals(buffer.trim())){
														isValidTag = true;
													} else {
														isValidTag = false;
														break;
													}
												} else {
													isValidTag = false;
													break;
												}
											}
										}
									}
									pop_tag_nm = null; // 반드시 초기화 한다.
								}
								log.error("\n OUT OF WHILE LOOP  isValidTag -"+JSPUtil.getNull(isValidTag)+"<<<<\n");
								
								log.error("\n st.isEmpty() : "+(st!=null?st.isEmpty():"-ST NULL-")+" \n");
								if (!st.isEmpty()){
									isValidTag = false;
									log.error("\n Invalid Stack Status confirmed \n");
									while(!st.isEmpty()){
										log.error("\n rest of st -> st.pop():"+(st!=null?st.pop():"")+" \n");
									}
								}
								log.error("\n JUST AFTER CHECK STACK -  isValidTag -"+JSPUtil.getNull(isValidTag)+"<<<<\n");
							}
						}
					} else {
						isValidTag = true;
						log.error("\n  NO INVOICE TAG CHECK FLAG DEFINED!!! <<<<\n");
					}
				} else {
					log.error("\n No EDI Main Rule found Exception!!! \n");
					throw new EventException("\n No EDI Main Rule found Exception!!! \n");
				}
			}
		} catch (java.io.IOException e){
			log.error(e.getMessage());
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} finally {
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
		}
		log.error("\n isValidTag : "+(isValidTag)+">>>>>>>>>>>>>>>>>>>>> \n");
		return isValidTag;
	}
	
	/**
	 * EDI data를 EDI와 약속된 규칙으로 Invoice별로 F/F을 나누기
	 * 
	 * @param str_ffs
	 * @param tesEdiRuleMainVO
	 * @return String[]
	 * @exception EventException
	 */
	public static String[] getEDIInvoiceStrs(String str_ffs, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) throws EventException {
		log.debug("\n TESeBillingManageUtil-getEDIInvoiceStrs~~~~~ \n");
		
		String[] strs = null;
		StringBuffer sb = null;
		java.io.BufferedReader br = null;
		java.io.StringReader sr = null;
		int cnt_tag = 0;
		int idx = 0;
		
		try {
			
			/**
			 * EDI data를 EDI와 약속된 규칙으로 Invoice별로 F/F을 나누기
			 * 복수개의 EDI Invoice가 올 경우'{INVOICE'로 열고 '}INVOICE'로 닫는다.
			 * 혹은 EDI RULE을 보고 그냥 통으로 넘길지 정한다.
			 * 
			 */

			if (str_ffs!=null && !str_ffs.trim().equals("")){
				if (tesEdiRuleMainVO!=null){
					if (tesEdiRuleMainVO.getInvTagNm()!=null && !tesEdiRuleMainVO.getInvTagNm().trim().equals("")){
						/**
						 * EDI RULE에서 INVOICE구분자가 있을 경우 해당 구분자로 F/F을 나눠서 String[]로 return한다.
						 */
						String tag_nm = tesEdiRuleMainVO.getInvTagNm().trim();
						log.debug("\n tag_nm:"+tag_nm+" \n");
						for (int j=str_ffs.indexOf("{"+tag_nm,0); 
				 				str_ffs!=null && !str_ffs.trim().equals("") && str_ffs.indexOf("{"+tag_nm)!=-1 && str_ffs.indexOf("{"+tag_nm,j)!=-1; 
				 				j=(str_ffs.indexOf("{"+tag_nm,j)!=-1)?str_ffs.indexOf("{"+tag_nm,j)+tag_nm.length():j++) 
						{
							cnt_tag++;
						}
						log.debug("\n cnt_tag:"+cnt_tag+"\n");
						if (cnt_tag>0){
							strs = new String[cnt_tag];
							if (tag_nm!=null && !tag_nm.trim().equals("") && strs!=null && strs.length>0){
								String buffer = null;
								String curr_blk = null;
								sr = new java.io.StringReader(str_ffs);
								br = new java.io.BufferedReader(sr);
								while ((buffer=br.readLine())!=null){
									if (buffer!=null && !buffer.trim().equals("")){
										if (buffer.trim().startsWith("{"+tag_nm)){
											curr_blk = buffer.trim();
											if (tag_nm!=null && buffer.trim().equals("{"+tag_nm.trim())) {
												sb = new StringBuffer();
												strs[idx] = new String();
											}
										} else if (buffer!=null && buffer.trim().startsWith("}"+tag_nm)){
											if (buffer!=null && buffer.trim().equals("}"+tag_nm.trim())) {
												if (idx<=cnt_tag){
													strs[idx] = (strs[idx]!=null?(sb!=null?sb.toString():""):null);
													sb = null;
													curr_blk = null;
													++idx;
												}
											}
										} else {
											if (curr_blk!=null && curr_blk.equals("{"+tag_nm) && buffer!=null && !buffer.trim().equals("{"+tag_nm)){
												if (strs[idx]!=null){
													sb.append(buffer.trim()+"\n");
												}
											}
										}
									}
								}
							}
						} else {
							/**
							 * EDI Rule에서 INVOICE별 구분 tag가 있더라도 실제로 F/F에서는 안보이면 하나의 INVOICE로 간주하고 통째로 String 배열하나로 그대로 다 넘긴다.
							 */					
							strs = new String[1];
							strs[0] = (str_ffs!=null && !str_ffs.trim().equals("")?str_ffs:"");
						}
					} else {
						/**
						 * EDI Rule에서 INVOICE별 구분 tag가 없다고 확인이 되면 F/F을 통째로 String 배열하나로 그대로 다 넘긴다.
						 */					
						strs = new String[1];
						strs[0] = (str_ffs!=null && !str_ffs.trim().equals("")?str_ffs:"");
					}
				} else {
					log.error("\n No EDI Main Rule found Exception!!! \n");
					throw new EventException("\n No EDI Main Rule found Exception!!! \n");
				}
			}
			
		} catch (java.io.IOException e){
			log.error(e.getMessage());
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
			throw new EventException(e.getMessage());
		} finally {
			try {
				if (sr!=null) {
					sr.close();
				}
				if (br!=null) {
					br.close();
				}
			} catch (java.io.IOException ie){
				log.error(ie.getMessage());
				throw new EventException(ie.getMessage());
			}
		}
		 
		return strs;
	}
	
	/**
	 * EDI VNDR구분자로 해당 BCIMPL instance를 구한다.
	 * 구주 EDI VNDR와 협의 결과로 VNDR SEQ.까지 분기에 추가할 경우가 생길것으로 예상 -> VNDR SEQ.받는부분의 주석 제거하여 사용
	 * 
	 * @param tesEdiRuleMainVO
	 * @return TESeBillingManageBC
	 * @throws EventException
	 */
	public static TESeBillingManageBC getBcInstance(ComTesEdiRcvRuleVndrMgmtVO tesEdiRuleVndrVO) throws EventException { 
		log.error("\n\n TESeBillingManageUtil --> BEGIN - getBcInstance() - ########################################### ");
		
		TESeBillingManageBC tes_command = null;

		try {
			if (tesEdiRuleVndrVO!=null){
				TESeBillingManageBizType000BC ediDtlImpl = getDtlImplInstance(tesEdiRuleVndrVO);
				if (ediDtlImpl != null){
					if (tesEdiRuleVndrVO.getImplMnTpCd()!=null && !tesEdiRuleVndrVO.getImplMnTpCd().trim().equals("")){
						if (tesEdiRuleVndrVO.getImplMnTpCd().trim().equals("01")){ //일단 '01'만 사용하고, 필요시 나중에 확장한다. - 거의 확장할 만한 일은 없을듯 함 혹시나해서리
							tes_command = new TESeBillingManage01BCImpl(ediDtlImpl);		
						}
					} else {
						log.error("\n No Implementation Main Type code  found Exception!!! \n");
						throw new EventException("\n No proper TESeBillingManageBizType000BC found Exception!!! \n");
					}
				} else {
					log.error("\n No proper TESeBillingManageBizType000BC found Exception!!! \n");
					throw new EventException("\n No proper TESeBillingManageBizType000BC found Exception!!! \n");
				}
			} else {
				log.error("\n No EDI Main Rule found Exception!!! \n");
				throw new EventException("\n No EDI Main Rule found Exception!!! \n");
			}
		} catch(Exception ex){
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		log.error("\n\n END - getInstance - ########################################### ");
		
		return tes_command;
	}
	
	/**
	 * EDI RULE 정보를 받아서 정해진 구분자로 DTLIMPL instance를 구한다.
	 * SNDR별 지정된 TYPE값을 가져와 해당 DETAIL TYPE IMPL을 생성하여 RETURN한다. 
	 * 
	 * <중> 위대하신 R4J님이 절대 Class.forName()을 사용하여 동적으로 class를 생성하지 말라고하신다... 그러면 그냥 박아넣어삼
	 * 
	 * @param tesEdiRuleVndrVO
	 * @return TESeBillingManageBizType000BC
	 * @throws EventException
	 */
	public static TESeBillingManageBizType000BC getDtlImplInstance(ComTesEdiRcvRuleVndrMgmtVO tesEdiRuleVndrVO) throws EventException { 
		log.error("\n\n TESeBillingManageUtil --> BEGIN - getDtlImplInstance() - ########################################### ");
		
		TESeBillingManageBizType000BC ediDtlImpl = null;
		
		try {
			if (tesEdiRuleVndrVO!=null){
				if (tesEdiRuleVndrVO!=null && tesEdiRuleVndrVO.getEdiVndrSeq()!=null && !tesEdiRuleVndrVO.getEdiVndrSeq().equals("")){
					if (tesEdiRuleVndrVO.getImplTpCd()!=null && !tesEdiRuleVndrVO.getImplTpCd().equals("")){
						
						log.debug("\n TESeBillingManageUtil.getDtlImplInstance - tesEdiRuleVndrVO.getImplTpCd() : "+(tesEdiRuleVndrVO.getImplTpCd())+"<<< \n");
						
						/**
						 *  <중> 위대하신 R4J님이 절대 Class.forName(~~)을 사용하여 동적으로 class를 생성하지 말라고 하신다. 젠장 그러면 그냥 박아넣어 처리하삼 
						 **/
						//ediDtlImpl = (TESeBillingManageBizType000BC)Class.forName("com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingManageDetailType"+tesEdiRuleVndrVO.getImplTpCd().trim()+"BCImpl").newInstance();
						
						if (tesEdiRuleVndrVO.getImplTpCd().trim().equals("001")){
							ediDtlImpl = new TESeBillingManageBizType001BCImpl();
						} else if (tesEdiRuleVndrVO.getImplTpCd().trim().equals("002")){
							ediDtlImpl = new TESeBillingManageBizType002BCImpl();
						} else if (tesEdiRuleVndrVO.getImplTpCd().trim().equals("003")){
							ediDtlImpl = new TESeBillingManageBizType003BCImpl();
						} else if (tesEdiRuleVndrVO.getImplTpCd().trim().equals("004")){
							ediDtlImpl = new TESeBillingManageBizType004BCImpl();
						}
					}
				}
			}
//		} catch(ClassNotFoundException ex){
//			/*** Class.forName()을 사용할 경우 Exception 처리 추가  ***/
//			log.error(ex.getMessage());
//			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		log.error("\n\n END - getDtlImplInstance - ########################################### ");
		
		return ediDtlImpl;
	}
	
	/**
	 * EDI data의 임시저장시 사용할 query에서의 Exclude 속성을 구한다.
	 * ~~ 동적으로 Class를 생성할 수 있게 R4J님이 허용해준다면 아래의 분기를 DB인자로 대체가능하다. ~~
	 * 
	 * @param tesEdiRcvFltFileXcldVOlist
	 * @param tesEdiInitVO
	 * @return String[][]
	 * @throws EventException
	 */
	public static String[][] getExcColsNVal( List<ComTesEdiRcvFltFileXcldVO> tesEdiRcvFltFileXcldVOlist, TesEdiSoHdrVO tesEdiInitVO ) throws EventException {
		log.error("\n BBB - TESeBillingManageUtil.getExcColsNVal() - ########################################### ");
		
		int tabColsSize = 0;
		String[][] xlcColsNVals = null;
		
		try {
			log.debug("\n tesEdiRcvFltFileXcldVOlist.size:"+(tesEdiRcvFltFileXcldVOlist!=null?tesEdiRcvFltFileXcldVOlist.size():0)+" \n");
			if (tesEdiRcvFltFileXcldVOlist!=null && tesEdiRcvFltFileXcldVOlist.size()>0 && tesEdiInitVO!=null){
				tabColsSize = (tesEdiRcvFltFileXcldVOlist!=null?tesEdiRcvFltFileXcldVOlist.size():0);
				if (tabColsSize>0){
					xlcColsNVals = new String[tabColsSize][2];	
				}
				String rplcActVal = null;
				String dftValCtnt = null;
				String rplcCtnt = null;
				for (int i=0; tesEdiRcvFltFileXcldVOlist!=null && i<tesEdiRcvFltFileXcldVOlist.size(); i++){
					if (tesEdiRcvFltFileXcldVOlist.get(i)!=null){
						xlcColsNVals[i][0] = JSPUtil.getNull(tesEdiRcvFltFileXcldVOlist.get(i).getFltFileKeyNm());
						if (tesEdiRcvFltFileXcldVOlist.get(i).getDfltValCtnt()!=null && !tesEdiRcvFltFileXcldVOlist.get(i).getDfltValCtnt().trim().equals("")){
							if (tesEdiRcvFltFileXcldVOlist.get(i).getRplcValFlg()!=null && tesEdiRcvFltFileXcldVOlist.get(i).getRplcValFlg().trim().equals("Y")){
								if (tesEdiRcvFltFileXcldVOlist.get(i).getRplcValCtnt()!=null && !tesEdiRcvFltFileXcldVOlist.get(i).getRplcValCtnt().trim().equals("")){
									dftValCtnt = tesEdiRcvFltFileXcldVOlist.get(i).getDfltValCtnt();
									rplcCtnt = tesEdiRcvFltFileXcldVOlist.get(i).getRplcValCtnt();
//									log.debug("\n\n\n\n\n 1 rplcCtnt:"+JSPUtil.getNull(rplcCtnt)+" \n");
//									log.debug("\n 1 dftValCtnt:"+JSPUtil.getNull(dftValCtnt)+" \n");
									if (rplcCtnt!=null && rplcCtnt.trim().equals("TML_EDI_SO_OFC_CTY_CD")){
										rplcActVal = tesEdiInitVO.getTmlEdiSoOfcCtyCd();
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("TML_EDI_SO_SEQ")){
										rplcActVal = tesEdiInitVO.getTmlEdiSoSeq();
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("INV_OFC_CD")){
										rplcActVal = tesEdiInitVO.getInvOfcCd();
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("TML_INV_EDI_SEQ")){
										rplcActVal = tesEdiInitVO.getTmlInvEdiSeq();
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("SNDR_ID")){
										rplcActVal = tesEdiInitVO.getSndrId();
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("RCVR_ID")){
										rplcActVal = tesEdiInitVO.getRcvrId();
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("EDI_MSG")){
										rplcActVal = JSPUtil.getNull(tesEdiInitVO.getEdiMsg());
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("FLT_FILE_MSG_ID")){
										rplcActVal = JSPUtil.getNull(tesEdiInitVO.getFltFileMsgId());
									} else if (rplcCtnt!=null && rplcCtnt.trim().equals("EDI_RCV_RULE_MN_SEQ")){
										rplcActVal = JSPUtil.getNull(tesEdiInitVO.getEdiRcvRuleMnSeq());
									}
//									log.debug("\n rplcActVal:"+JSPUtil.getNull(rplcActVal)+" \n");
									if (rplcActVal!=null){ // && !rplc.trim().equals("")){ //KEY값이 아닌경우 빈값으로 채워질 수도 있다...
										dftValCtnt = JSPUtil.replace(dftValCtnt,tesEdiRcvFltFileXcldVOlist.get(i).getRplcValCtnt(),rplcActVal);
										if (JSPUtil.getNull(tesEdiRcvFltFileXcldVOlist.get(i).getQttnConcFlg()).equals("Y")){
											dftValCtnt = "'"+JSPUtil.getNull(dftValCtnt)+"'";
										}
									}
//									log.debug("\n 2 rplcCtnt:"+JSPUtil.getNull(rplcCtnt)+" \n");
//									log.debug("\n 2 dftValCtnt:"+JSPUtil.getNull(dftValCtnt)+" \n");
									xlcColsNVals[i][1] = JSPUtil.getNull(dftValCtnt);
								} else {
									xlcColsNVals[i][1] = tesEdiRcvFltFileXcldVOlist.get(i).getDfltValCtnt();
								}
							} else {
								xlcColsNVals[i][1] = tesEdiRcvFltFileXcldVOlist.get(i).getDfltValCtnt();	
							}
						}
					}
				}
			}
			
//			log.debug("\n\n\n\n\n");
//			for (int k=0; xlcColsNVals!=null && k<xlcColsNVals.length; k++){
//				//test
//				log.debug("\n xlcColsNVals["+k+"][0] : "+xlcColsNVals[k][0]+"  -  xlcColsNVals["+k+"][1] : "+xlcColsNVals[k][1] +" \n");
//			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
		log.error("\n EEE - TESeBillingManageUtil.getExcColsNVal() - ########################################### ");
		
		return xlcColsNVals;
	}

	/**
	 * EDI VNDR별 Rule을 구하고 설정한다.
	 * 
	 * @param tesEdiInitVO
	 * @param tesEdiRuleMainVO
	 * @throws EventException
	 */
	public void getSetEdiVndrRules(TesEdiSoHdrVO tesEdiInitVO, ComTesEdiRcvRuleMnVO tesEdiRuleMainVO) throws EventException {
		log.debug("\n TESeBillingManageUtil-getSetEdiVndrRules~~~~~BBBB \n");
		TESeBillingCommonBC tes_com_command = new TESeBillingCommonBCImpl();
		if (tes_com_command!=null){
			tes_com_command.getSetEdiVndrRules(tesEdiInitVO, tesEdiRuleMainVO);
		}
	}
	
	/**
	 * ERROR발생시 LOG를 저장한다.
	 * 
	 * @param tesEdiErrLogVO
	 * @throws EventException
	 */
	public void logEDIErrMsg(TesEdiSoErrLogVO tesEdiErrLogVO) {
		log.debug("\n BBBB - TESeBillingManageUtil-logEDIErrMsg~~~~~ \n");
		try {
			TESeBillingCommonBC tes_com_command = new TESeBillingCommonBCImpl();
			if (tes_com_command!=null){
				tes_com_command.logEDIErrMsg(tesEdiErrLogVO);	
			}
		} catch(Exception e){
			log.error(e.getMessage());
		}

		log.debug("\n EEEE - TESeBillingManageUtil-logEDIErrMsg~~~~~ \n");
	}	
}