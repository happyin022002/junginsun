/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RepairMgtDBDAOmodifyEstimateTmpDTLDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.11.08 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOmodifyEstimateTmpDTLDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyEstimateTmpDTLData
	  * --------------------------------------------------------
	  * History
	  * 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
	  * </pre>
	  */
	public RepairMgtDBDAOmodifyEstimateTmpDTLDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_tmp_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOmodifyEstimateTmpDTLDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_RPR_RQST_TMP_DTL TMP" ).append("\n"); 
		query.append("   SET (TMP.RPR_LBR_HRS," ).append("\n"); 
		query.append("        TMP.RPR_LBR_BZC_HRS," ).append("\n"); 
		query.append("        TMP.UPD_DT)" ).append("\n"); 
		query.append("     = (SELECT INP_MSG16," ).append("\n"); 
		query.append("               INP_MSG16," ).append("\n"); 
		query.append("               SYSDATE" ).append("\n"); 
		query.append("          FROM MNR_DAT_VRFY" ).append("\n"); 
		query.append("         WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("           AND TMP_DTL_SEQ = TMP.RPR_RQST_TMP_DTL_SEQ)" ).append("\n"); 
		query.append(" WHERE RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("   AND RPR_RQST_TMP_SEQ = @[rpr_rqst_tmp_seq]" ).append("\n"); 
		query.append("   AND RPR_RQST_TMP_VER_NO = @[rpr_rqst_tmp_ver_no]" ).append("\n"); 

	}
}