/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchBkgCaFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchBkgCaFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bl no 로 bkg_no, caFlg , ctrt_tp_cd 조회
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchBkgCaFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchBkgCaFlgRSQL").append("\n"); 
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
		query.append("SELECT  BL_NO              ," ).append("\n"); 
		query.append("BKG_NO             ," ).append("\n"); 
		query.append("SVC_SCP_CD         ," ).append("\n"); 
		query.append("CTRT_TP_CD         ," ).append("\n"); 
		query.append("MAX(CA_FLG) CA_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  BL_NO  ," ).append("\n"); 
		query.append("BKG_NO ," ).append("\n"); 
		query.append("SVC_SCP_CD ," ).append("\n"); 
		query.append("CASE WHEN TAA_NO IS NOT NULL THEN 'T'" ).append("\n"); 
		query.append("WHEN RFA_NO IS NOT NULL THEN 'R'" ).append("\n"); 
		query.append("WHEN SC_NO  IS NOT NULL THEN 'S'" ).append("\n"); 
		query.append("ELSE 'T'" ).append("\n"); 
		query.append("END CTRT_TP_CD  ," ).append("\n"); 
		query.append("'N' CA_FLG" ).append("\n"); 
		query.append("FROM    BKG_BOOKING" ).append("\n"); 
		query.append("WHERE   BL_NO = @[bl_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  BL_NO  ," ).append("\n"); 
		query.append("BKG_NO ," ).append("\n"); 
		query.append("SVC_SCP_CD ," ).append("\n"); 
		query.append("CASE WHEN TAA_NO IS NOT NULL THEN 'T'" ).append("\n"); 
		query.append("WHEN RFA_NO IS NOT NULL THEN 'R'" ).append("\n"); 
		query.append("WHEN SC_NO  IS NOT NULL THEN 'S'" ).append("\n"); 
		query.append("ELSE 'T'" ).append("\n"); 
		query.append("END CTRT_TP_CD  ," ).append("\n"); 
		query.append("'Y' CA_FLG" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS" ).append("\n"); 
		query.append("WHERE   BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("AND     CORR_NO = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("BL_NO      ," ).append("\n"); 
		query.append("BKG_NO     ," ).append("\n"); 
		query.append("SVC_SCP_CD ," ).append("\n"); 
		query.append("CTRT_TP_CD" ).append("\n"); 

	}
}