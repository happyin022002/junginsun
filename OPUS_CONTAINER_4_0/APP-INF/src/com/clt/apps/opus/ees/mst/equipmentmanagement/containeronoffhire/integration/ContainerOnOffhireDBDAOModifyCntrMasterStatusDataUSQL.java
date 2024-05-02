/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterStatusData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("approval_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER MC SET " ).append("\n"); 
		query.append("(LST_STS_SEQ, CNTR_STS_CD,LST_STS_YD_CD) = (" ).append("\n"); 
		query.append("	    SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ, A.CNTR_STS_CD, A.YD_CD " ).append("\n"); 
		query.append("	    FROM   MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("	    WHERE A.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("          AND CASE WHEN (SELECT /*+ INDEX_DESC(CHK XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                CHK.CNTR_STS_CD" ).append("\n"); 
		query.append("                           FROM MST_CNTR_STS_HIS CHK " ).append("\n"); 
		query.append("                          WHERE CHK.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                            AND ROWNUM       = 1) = 'LSI' THEN 'ALL'" ).append("\n"); 
		query.append("              ELSE DECODE((SELECT /*+ INDEX_DESC(SH XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                  DECODE(SUBSTR(SH.CNTR_STS_CD, -1), 'O', 'Y', 'N') CHK_OUT " ).append("\n"); 
		query.append("                             FROM MST_CNTR_STS_HIS SH" ).append("\n"); 
		query.append("                            WHERE SH.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                              AND SUBSTR(SH.CNTR_STS_CD, 1, 2) IN ( 'SB', 'MU', 'SR')" ).append("\n"); 
		query.append("                              AND ROWNUM = 1), 'Y', A.CNTR_STS_CD, 'ALL')" ).append("\n"); 
		query.append("              END IN  ('ALL', 'SBO', 'MUO', 'SRO')" ).append("\n"); 
		query.append("	    AND ROWNUM =1" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(",(LSTM_CD,AGMT_CTY_CD,AGMT_SEQ,VNDR_SEQ,ONH_FREE_DYS,MIN_ONH_DYS, ONH_CNTR_STS_CD,ONH_DT,ONH_YD_CD,ONH_STS_SEQ) " ).append("\n"); 
		query.append("        = (SELECT LA.LSTM_CD, LA.AGMT_CTY_CD,LA.AGMT_SEQ,LA.VNDR_SEQ, B.RNTL_CHG_FREE_DYS,B.CNTR_MIN_ONH_DYS," ).append("\n"); 
		query.append("                  B.CNTR_STS_CD,B.CNTR_STS_EVNT_DT,B.YD_CD,B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("           FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("              , LSE_AGREEMENT LA" ).append("\n"); 
		query.append("           WHERE B.AGMT_CTY_CD  = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND   B.AGMT_SEQ     = LA.AGMT_SEQ" ).append("\n"); 
		query.append("           AND   B.CNTR_NO      = MC.CNTR_NO" ).append("\n"); 
		query.append("           AND   B.CNTR_STS_SEQ = MST_ONH_STS_SEQ_FNC(MC.CNTR_NO))					" ).append("\n"); 
		query.append(",	CRNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("#if (${st_cd} == '0' || ${st_cd} == '1' || ${st_cd} == '3' || ${st_cd} == '5' || ${st_cd} == '11') " ).append("\n"); 
		query.append(",	CNMV_STS_CD = 'XX'" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '2' || ${st_cd} == '4' || ${st_cd} == '6') " ).append("\n"); 
		query.append(",	CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append(",   UCLM_LS_DIV_CD 	= NULL" ).append("\n"); 
		query.append(",   UCLM_DT 		= NULL" ).append("\n"); 
		query.append(",   UCLM_FREE_DYS	= NULL" ).append("\n"); 
		query.append(",   UCLM_END_DT		= NULL" ).append("\n"); 
		query.append(",   UCLM_RSN		= NULL" ).append("\n"); 
		query.append(",   UCLM_PLN_RMK	= NULL" ).append("\n"); 
		query.append(",   UCLM_CNTC_PNT_NM = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '1' || ${st_cd} == '3')" ).append("\n"); 
		query.append(",	CNTR_OFFH_AUTH_NO = @[approval_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",   (SCC_CD, ECC_CD, LCC_CD, RCC_CD) = (SELECT A.SCC_CD,B.ECC_CD,B.LCC_CD,B.RCC_CD " ).append("\n"); 
		query.append("                                        FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B " ).append("\n"); 
		query.append("                                        WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                                        AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   CNTR_RMK = @[cntr_rmk]" ).append("\n"); 
		query.append(",   FULL_FLG = DECODE(@[full_flg], 'F', 'Y', 'M', 'N')" ).append("\n"); 
		query.append("WHERE	MC.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}