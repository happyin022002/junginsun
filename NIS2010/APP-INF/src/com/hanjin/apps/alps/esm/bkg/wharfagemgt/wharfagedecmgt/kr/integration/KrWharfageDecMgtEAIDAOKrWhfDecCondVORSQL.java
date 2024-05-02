/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KrWharfageDecMgtEAIDAOKrWhfDecCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtEAIDAOKrWhfDecCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KrWhfDecCondVO 생성위해 사용
	  * </pre>
	  */
	public KrWharfageDecMgtEAIDAOKrWhfDecCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtEAIDAOKrWhfDecCondVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT " ).append("\n"); 
		query.append("	 '' cntr_40_Ut_Rt" ).append("\n"); 
		query.append("	,'' edi_Msg_Snd_Id" ).append("\n"); 
		query.append("	,'' csr_No " ).append("\n"); 
		query.append("	,'' send" ).append("\n"); 
		query.append("	,'' whf_Bnd_Cd " ).append("\n"); 
		query.append("	,'' whf_Decl_Ofc_Cd " ).append("\n"); 
		query.append("	,'' whf_Ntc_No" ).append("\n"); 
		query.append("	,'' ntc_Amt " ).append("\n"); 
		query.append("	,'' whf_Decl_No" ).append("\n"); 
		query.append("	,'' mf_Ref_No " ).append("\n"); 
		query.append("	,'' blk_Rt_Rto " ).append("\n"); 
		query.append("	,'' vvd " ).append("\n"); 
		query.append("	,'' whf_Rt_Amt " ).append("\n"); 
		query.append("	,'' rduc_Amt " ).append("\n"); 
		query.append("	,'' cntr_45_Ut_Rt" ).append("\n"); 
		query.append("	,'' port_Cd " ).append("\n"); 
		query.append("	,'' blk_Ut_Rt " ).append("\n"); 
		query.append("	,'' cntr_20_Ut_Rt " ).append("\n"); 
		query.append("	,'' whf_Usr_Nm " ).append("\n"); 
		query.append("	,'' cancel_Flag" ).append("\n"); 
		query.append("	,'' ofc_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}