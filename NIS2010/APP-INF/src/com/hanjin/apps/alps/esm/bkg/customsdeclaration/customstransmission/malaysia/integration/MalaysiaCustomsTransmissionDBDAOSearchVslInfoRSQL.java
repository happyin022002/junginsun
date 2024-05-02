/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_i_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchVslInfoRSQL").append("\n"); 
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
		query.append("       BKG_GET_TOKEN_FNC(SCN_VID,1)  AS VSL_CALL_NO" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(SCN_VID,2)  AS VSL_ID       " ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(MY_MF_STN_TML_CD,1)  AS CUSTOMS_STATION_CD" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(MY_MF_STN_TML_CD,2)  AS TERMINAL_OP_CD" ).append("\n"); 
		query.append("     , X.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT    @[e_i_ind] E_I_IND" ).append("\n"); 
		query.append("         ,@[trsm_sts] STATUS" ).append("\n"); 
		query.append("         ,P.VSL_CD||P.SKD_VOY_NO||P.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("         ,NVL(V.VSL_ENG_NM,' ') VSL_FULLNAME" ).append("\n"); 
		query.append("         ,V.LLOYD_NO VSL_AUTH_NO" ).append("\n"); 
		query.append("         ,V.VSL_RGST_CNT_CD VSL_NATION_CD" ).append("\n"); 
		query.append("         ,P.VPS_PORT_CD PORT" ).append("\n"); 
		query.append("         ,L.LOC_NM PORT_NM" ).append("\n"); 
		query.append("         ,TO_CHAR(P.VPS_ETA_DT,'YYYYMMDD') ETA" ).append("\n"); 
		query.append("         ,TO_CHAR(P.VPS_ETD_DT,'YYYYMMDD') ETD" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("         ,'T' TS_TP_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("         ,'L' TS_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		 ,(SELECT CVY_REF_NO||','||UQ_VSL_ID_NO" ).append("\n"); 
		query.append("             FROM BKG_VSL_DCHG_YD D " ).append("\n"); 
		query.append("            where D.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("              AND D.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("              AND D.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("			#if (${e_i_ind} == 'E')" ).append("\n"); 
		query.append("			  AND D.PORT_CD = @[input_pol_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			  AND D.PORT_CD = @[input_pod_cd]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("			#end              " ).append("\n"); 
		query.append("			  and ROWNUM = 1 ) SCN_VID" ).append("\n"); 
		query.append("          ,(SELECT" ).append("\n"); 
		query.append("                  ATTR_CTNT2||','||ATTR_CTNT3" ).append("\n"); 
		query.append("              FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("             WHERE HRD_CDG_ID = 'MY_MF_STN_TML_CD'" ).append("\n"); 
		query.append("               AND ATTR_CTNT1 = P.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) MY_MF_STN_TML_CD" ).append("\n"); 
		query.append("FROM      VSK_VSL_PORT_SKD P, MDM_VSL_CNTR V, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       P.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND       P.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND       P.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${e_i_ind} == 'E')" ).append("\n"); 
		query.append("AND       P.VPS_PORT_CD = @[input_pol_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       P.VPS_PORT_CD = @[input_pod_cd]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND       L.LOC_CD=P.VPS_PORT_CD" ).append("\n"); 
		query.append("AND       V.VSL_CD(+) = P.VSL_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}