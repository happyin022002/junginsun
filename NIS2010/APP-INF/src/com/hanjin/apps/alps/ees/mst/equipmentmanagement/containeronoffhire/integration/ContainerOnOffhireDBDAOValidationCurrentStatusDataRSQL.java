/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOValidationCurrentStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOValidationCurrentStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidationCurrentStatusData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOValidationCurrentStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOValidationCurrentStatusDataRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(1)||'' AS RESSTR, '' AS RESSTR1 " ).append("\n"); 
		query.append("FROM MST_CNTR_PRE_STS A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${st_cd} == '0')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '1')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'SBO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '2')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'SBI'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '3')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'MUO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '4')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'MUI'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '5')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'SRO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '6')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'SRI'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '7')" ).append("\n"); 
		query.append("AND   A.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.CNTR_PRE_STS_CD =  (SELECT  AA.CNTR_STS_CD" ).append("\n"); 
		query.append("                            FROM MST_CONTAINER AA" ).append("\n"); 
		query.append("							WHERE 1 = 1" ).append("\n"); 
		query.append("							AND   AA.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(A.CRNT_YD_CD, @[sts_evnt_yd_cd], '1','0') AS RESSTR, " ).append("\n"); 
		query.append("       CASE WHEN TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') <= @[hire_date] THEN '0'" ).append("\n"); 
		query.append("       ELSE '1' END RESSTR1 " ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#if (${st_cd} == '1' || ${st_cd} == '3')" ).append("\n"); 
		query.append("SELECT COUNT(1)||'' AS RESSTR, '' RESSTR1 " ).append("\n"); 
		query.append("FROM LSE_AGMT_RT A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.LOC_CD = 'KRSEL'" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND A.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT '1' AS RESSTR, '' RESSTR1 " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '7')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(LSTM_CD ,'SH','1','0') AS RESSTR , '' RESSTR1 " ).append("\n"); 
		query.append("FROM  MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO =@[cntr_no] " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(B XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("DECODE(B.MVMT_STS_CD,'OP','1','OC','1','TN','1','EN','1','0') AS RESSTR " ).append("\n"); 
		query.append(", NVL((SELECT DECODE(MIN(BKG_STS_CD),'X','1',0)  FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT BK.BKG_STS_CD FROM BKG_BOOKING BK, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND CNTR.CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("    AND CNTR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    AND CNMV_CYC_NO = (SELECT MAX(CNMV_CYC_NO) FROM BKG_CONTAINER WHERE CNTR_NO = CNTR.CNTR_NO)" ).append("\n"); 
		query.append(")),1)   RESSTR1" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT B" ).append("\n"); 
		query.append("WHERE  CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}