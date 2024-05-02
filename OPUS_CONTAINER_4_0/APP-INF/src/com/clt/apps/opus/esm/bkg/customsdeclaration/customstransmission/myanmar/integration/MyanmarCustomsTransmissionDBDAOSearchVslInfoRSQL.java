/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.19
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.11.19 윤태승
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOSearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchVslInfoRSQL(){
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
		params.put("v_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("v_pod",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchVslInfoRSQL").append("\n"); 
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
		query.append("SELECT    @[e_i_ind] E_I_IND" ).append("\n"); 
		query.append(",@[trsm_sts] STATUS" ).append("\n"); 
		query.append(",P.VSL_CD||P.SKD_VOY_NO||P.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",NVL(V.VSL_ENG_NM,' ') VSL_FULLNAME" ).append("\n"); 
		query.append(",V.LLOYD_NO VSL_AUTH_NO" ).append("\n"); 
		query.append(",V.VSL_RGST_CNT_CD VSL_NATION_CD" ).append("\n"); 
		query.append(",P.VPS_PORT_CD PORT" ).append("\n"); 
		query.append(",L.LOC_NM PORT_NM" ).append("\n"); 
		query.append(",TO_CHAR(P.VPS_ETA_DT,'YYYYMMDD') ETA" ).append("\n"); 
		query.append(",TO_CHAR(P.VPS_ETD_DT,'YYYYMMDD') ETD" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append(",'T' TS_TP_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'L' TS_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM      VSK_VSL_PORT_SKD P, MDM_VSL_CNTR V, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       P.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND       P.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND       P.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${e_i_ind} == 'E')" ).append("\n"); 
		query.append("AND       P.VPS_PORT_CD = @[v_pol]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       P.VPS_PORT_CD = @[v_pod]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND       L.LOC_CD=P.VPS_PORT_CD" ).append("\n"); 
		query.append("AND       V.VSL_CD(+) = P.VSL_CD" ).append("\n"); 

	}
}