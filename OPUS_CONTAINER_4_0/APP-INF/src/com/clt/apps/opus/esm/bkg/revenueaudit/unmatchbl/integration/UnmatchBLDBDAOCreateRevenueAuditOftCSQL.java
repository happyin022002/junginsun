/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOCreateRevenueAuditOftCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.06 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCreateRevenueAuditOftCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateRevenueAuditOft
	  * </pre>
	  */
	public UnmatchBLDBDAOCreateRevenueAuditOftCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCreateRevenueAuditOftCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_AUD_CHG_TMP (" ).append("\n"); 
		query.append("BKG_NO      ," ).append("\n"); 
		query.append("OFT_CMB_SEQ ," ).append("\n"); 
		query.append("CHG_RT_SEQ  ," ).append("\n"); 
		query.append("CHG_CD      ," ).append("\n"); 
		query.append("RAT_UT_CD   ," ).append("\n"); 
		query.append("CURR_CD     ," ).append("\n"); 
		query.append("CHG_UT_AMT  ," ).append("\n"); 
		query.append("RAT_AS_QTY  ," ).append("\n"); 
		query.append("CHG_AMT     ," ).append("\n"); 
		query.append("CGO_CATE_CD ," ).append("\n"); 
		query.append("RCV_TERM_CD ," ).append("\n"); 
		query.append("DE_TERM_CD  ," ).append("\n"); 
		query.append("CRE_USR_ID  ," ).append("\n"); 
		query.append("CRE_DT      ," ).append("\n"); 
		query.append("UPD_USR_ID  ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO      ," ).append("\n"); 
		query.append("OFT_CMB_SEQ ," ).append("\n"); 
		query.append("OFRT_SEQ    ," ).append("\n"); 
		query.append("CHG_CD      ," ).append("\n"); 
		query.append("RAT_UT_CD   ," ).append("\n"); 
		query.append("CURR_CD     ," ).append("\n"); 
		query.append("CHG_UT_AMT  ," ).append("\n"); 
		query.append("RAT_AS_QTY  ," ).append("\n"); 
		query.append("CHG_AMT     ," ).append("\n"); 
		query.append("CGO_CATE_CD ," ).append("\n"); 
		query.append("RCV_TERM_CD ," ).append("\n"); 
		query.append("DE_TERM_CD  ," ).append("\n"); 
		query.append("CRE_USR_ID  ," ).append("\n"); 
		query.append("SYSDATE     ," ).append("\n"); 
		query.append("UPD_USR_ID  ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM   BKG_AUTO_RT_OCN_FRT_TMP" ).append("\n"); 

	}
}