/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecEdiVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.03.04 이수진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Su Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecEdiVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecEdiVvdRSQL(){
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
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecEdiVvdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("@[vvd] AS VVD" ).append("\n"); 
		query.append(",A.CALL_SGN_NO AS VSL_CALLSIGN" ).append("\n"); 
		query.append(",NVL(B.VSL_ENG_NM,' ') AS VSL_FULLNAME" ).append("\n"); 
		query.append(",NVL(B.VSL_RGST_CNT_CD,' ') AS VSL_COUNTRY" ).append("\n"); 
		query.append(",TO_CHAR(C.VPS_ETA_DT,'YYYYMMDD') AS ETA" ).append("\n"); 
		query.append(",TO_CHAR(C.VPS_ETD_DT,'YYYYMMDD') AS ETD" ).append("\n"); 
		query.append(",NVL(@[pol_loc],'') AS POL" ).append("\n"); 
		query.append(",NVL(@[pod_loc],'') AS POD" ).append("\n"); 
		query.append(",@[whf_bnd_cd] AS IO_IND" ).append("\n"); 
		query.append(",@[whf_bnd_cd] AS SND_IND" ).append("\n"); 
		query.append(",A.BRTH_CD AS PORT_CD" ).append("\n"); 
		query.append(",A.TML_CD AS TMNL_CD" ).append("\n"); 
		query.append(",A.ARR_TMS_NO||A.ARR_YR AS IN_SEQ" ).append("\n"); 
		query.append("--,SUBSTR(A.UNLD_AGN_ID,1,2)||'-'||SUBSTR(A.UNLD_AGN_ID,3,1)||'-'||SUBSTR(A.UNLD_AGN_ID,4,4) AS DSCH_COM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(BKG_GET_BKG_CTMS_CD_ATTR1_FNC('KR','MANI_AGENT_CD',@[port_cd], 2) ,' ') AS DSCH_COM /*  선사/대리점 코드    */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",A.UNLD_TP_CD AS DSCH_IND" ).append("\n"); 
		query.append(",A.WHF_VOL_DC_CD AS DSC_RATE" ).append("\n"); 
		query.append(",SUM(A.FULL_45FT_CNTR_QTY) AS F45_TTL" ).append("\n"); 
		query.append(",SUM(A.FULL_40FT_CNTR_QTY) AS F40_TTL" ).append("\n"); 
		query.append(",'' AS F35_TTL" ).append("\n"); 
		query.append(",SUM(A.FULL_20FT_CNTR_QTY) AS F20_TTL" ).append("\n"); 
		query.append(",'' AS F10_TTL" ).append("\n"); 
		query.append(",'' AS FETC_TTL" ).append("\n"); 
		query.append(",SUM(A.MTY_45FT_CNTR_QTY) AS E45_TTL" ).append("\n"); 
		query.append(",SUM(A.MTY_40FT_CNTR_QTY) AS E40_TTL" ).append("\n"); 
		query.append(",'' AS E35_TTL" ).append("\n"); 
		query.append(",SUM(A.MTY_20FT_CNTR_QTY) AS E20_TTL" ).append("\n"); 
		query.append(",'' AS E10_TTL" ).append("\n"); 
		query.append(",'' AS EETC_TTL" ).append("\n"); 
		query.append(",SUM(A.RTON_WGT) AS RTON" ).append("\n"); 
		query.append(",SUM(A.WHF_RT_AMT) AS AMOUNT" ).append("\n"); 
		query.append(",SUM(A.EXPT_TON_WGT) AS FREE_RTON" ).append("\n"); 
		query.append(",trunc(SUM(A.EXPT_TON_WGT * A.WHF_RT), 0) AS FREE_AMOUNT" ).append("\n"); 
		query.append(",SUM(A.RTON_WGT + A.EXPT_TON_WGT) AS RTON_TTL" ).append("\n"); 
		query.append(",trunc(SUM(A.WHF_RT_AMT + (A.EXPT_TON_WGT * A.WHF_RT)), 0) AS AMOUNT_TTL" ).append("\n"); 
		query.append(",A.PAY_DT AS TAX_DATE" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_VOL A, MDM_VSL_CNTR B, VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND SUBSTR(A.WHF_BND_CD,1,1)   = SUBSTR(@[whf_bnd_cd],1,1)" ).append("\n"); 
		query.append("AND A.PORT_CD                  = @[port_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD                   = A.VSL_CD" ).append("\n"); 
		query.append("AND C.VSL_CD                   = A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO               = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD               = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.VPS_PORT_CD              = @[port_cd]" ).append("\n"); 
		query.append("-- AND NVL(C.VPS_CHANG_IND,' ')  != 'S'  컬럼이" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("GROUP BY A.CALL_SGN_NO," ).append("\n"); 
		query.append("B.VSL_ENG_NM," ).append("\n"); 
		query.append("B.VSL_RGST_CNT_CD," ).append("\n"); 
		query.append("C.VPS_ETA_DT," ).append("\n"); 
		query.append("C.VPS_ETD_DT," ).append("\n"); 
		query.append("A.PORT_CD," ).append("\n"); 
		query.append("A.TML_CD," ).append("\n"); 
		query.append("A.ARR_TMS_NO," ).append("\n"); 
		query.append("A.ARR_YR," ).append("\n"); 
		query.append("A.UNLD_AGN_ID," ).append("\n"); 
		query.append("A.UNLD_TP_CD," ).append("\n"); 
		query.append("A.WHF_VOL_DC_CD," ).append("\n"); 
		query.append("A.PAY_DT," ).append("\n"); 
		query.append("A.BRTH_CD" ).append("\n"); 

	}
}