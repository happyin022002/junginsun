/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOcreateVORRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.24
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.24 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOcreateVORRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * createVO
	  * </pre>
	  */
	public UnmatchBLDBDAOcreateVORRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOcreateVORRSQL").append("\n"); 
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
		query.append("/* RsltUnmatchStatusReportVO */" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append(" ''  BKG_OFC_CD " ).append("\n"); 
		query.append(",'' U_E_CNT" ).append("\n"); 
		query.append(",'' U_B_CNT " ).append("\n"); 
		query.append(",'' S_B_CNT" ).append("\n"); 
		query.append(",'' S_TL_MNL_DIFF_AMT " ).append("\n"); 
		query.append(",'' S_C_CNT " ).append("\n"); 
		query.append(",'' SETTLE_TERM " ).append("\n"); 
		query.append(",'' U_A_CNT " ).append("\n"); 
		query.append(",'' BL_U_CNT " ).append("\n"); 
		query.append(",'' U_C_CNT " ).append("\n"); 
		query.append(",'' U_F_CNT " ).append("\n"); 
		query.append(",'' S_F_CNT " ).append("\n"); 
		query.append(",'' BL_S_CNT " ).append("\n"); 
		query.append(",'' RT_APLY_DT_FROM " ).append("\n"); 
		query.append(",'' RT_APLY_DT_TO" ).append("\n"); 
		query.append(",'' S_E_CNT " ).append("\n"); 
		query.append(",'' S_A_CNT     " ).append("\n"); 
		query.append(",'' S_AL_CNT" ).append("\n"); 
		query.append(",'' S_ALL_CNT" ).append("\n"); 
		query.append(",'' AUTO_RAT_FLG " ).append("\n"); 
		query.append(",'' BKG_CTRT_TP_CD " ).append("\n"); 
		query.append(",'' U_D_CNT " ).append("\n"); 
		query.append(",'' RCT_RHQ_CD" ).append("\n"); 
		query.append(",'' S_D_CNT " ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}