/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.07.02 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * agreement Rate아래의 모든 Rate를 삭제하기전 Surcharge 삭제대상을 조회한다.
	  * </pre>
	  */
	public AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("x_trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("x_trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("x_trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetRSQL").append("\n"); 
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
		query.append("SELECT TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append(",TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append(",TO_CHAR(EFF_FM_DT,'YYYYMMDDHH24MISS') EFF_FM_DT" ).append("\n"); 
		query.append(",TO_CHAR(EFF_TO_DT,'YYYYMMDDHH24MISS') EFF_TO_DT" ).append("\n"); 
		query.append(",TO_WGT" ).append("\n"); 
		query.append(",WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRSP_ONE_WY_RT" ).append("\n"); 
		query.append(",TRSP_RND_RT" ).append("\n"); 
		query.append(",EQ_KND_CD" ).append("\n"); 
		query.append("FROM TRS_AGMT_SCG_RT" ).append("\n"); 
		query.append("WHERE TRSP_AGMT_OFC_CTY_CD   = @[x_trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND TRSP_AGMT_SEQ          = @[x_trsp_agmt_seq]" ).append("\n"); 
		query.append("AND TRSP_AGMT_RT_TP_SER_NO = @[x_trsp_agmt_rt_tp_ser_no]" ).append("\n"); 

	}
}