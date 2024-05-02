/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODRequestListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.19
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.03.19 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODRequestListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Approval 정보를 조회합니다.
	  * History-------------------------------------
	  * 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
	  * 2012.10.08 진마리아 CHM-201220208-01 COD APPROVAL 관련 요청 사항 (ETA,경과 시간 표시)
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODRequestListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODRequestListVORSQL").append("\n"); 
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
		query.append("SELECT A.VSL_SLAN_CD" ).append("\n"); 
		query.append(", A.VVD" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", A.COD_RQST_RSN_CD" ).append("\n"); 
		query.append(", A.OLD_POL" ).append("\n"); 
		query.append(", A.OLD_POD" ).append("\n"); 
		query.append(", A.OLD_DEL" ).append("\n"); 
		query.append(", A.NEW_POL" ).append("\n"); 
		query.append(", A.NEW_POD" ).append("\n"); 
		query.append(", A.NEW_DEL" ).append("\n"); 
		query.append(", COUNT(C.CNTR_NO) CNTR_QTY" ).append("\n"); 
		query.append(", A.COD_RQST_OFC_CD" ).append("\n"); 
		query.append(", A.COD_STS_CD" ).append("\n"); 
		query.append(", A.CHG_AMT" ).append("\n"); 
		query.append(", A.DIFF_RMK" ).append("\n"); 
		query.append(", A.BL_NO" ).append("\n"); 
		query.append(", A.COD_RQST_SEQ" ).append("\n"); 
		query.append(", A.COD_RHND_PORT_CD" ).append("\n"); 
		query.append(", A.ACT_DEPT_YN" ).append("\n"); 
		query.append(", A.POD_ETA_DT" ).append("\n"); 
		query.append(", A.COD_EMAIL_SEND_YN" ).append("\n"); 
		query.append(", A.NEW_VSL_CD" ).append("\n"); 
		query.append(", A.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(", A.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(", A.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(", (SELECT   MIN(TO_CHAR(PS.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("FROM     VSK_VSL_PORT_SKD   PS" ).append("\n"); 
		query.append("WHERE    PS.VSL_CD          = A.NEW_VSL_CD" ).append("\n"); 
		query.append("AND      PS.SKD_VOY_NO      = A.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append("AND      PS.SKD_DIR_CD      = A.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append("AND      PS.VPS_PORT_CD     = A.COD_RHND_PORT_CD" ).append("\n"); 
		query.append("AND      PS.YD_CD           = A.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(")                           AS RHND_PORD_ETA_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN MIN(A.FIRST_REACT_DATE) IS NULL THEN" ).append("\n"); 
		query.append("CASE WHEN LENGTH(ROUND(SYSDATE - A.REQ_DT,0)) > 3  THEN '999.9'" ).append("\n"); 
		query.append("ELSE TO_CHAR(SYSDATE - A.REQ_DT,'FM000.0')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN LENGTH(ROUND(MIN(A.FIRST_REACT_DATE) - A.REQ_DT,0)) > 3  THEN '999.9'" ).append("\n"); 
		query.append("ELSE TO_CHAR(MIN(A.FIRST_REACT_DATE) - A.REQ_DT,'FM000.0')" ).append("\n"); 
		query.append("END       AS ELAPSED_DAY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TO_CHAR(A.REQ_DT,'YYYY-MM-DD HH24:MI')     AS REQUESTED_DATE" ).append("\n"); 
		query.append(", TO_CHAR(MIN(A.FIRST_REACT_DATE),'YYYY-MM-DD HH24:MI')   AS FIRST_REACT_DATE" ).append("\n"); 
		query.append(", MIN(A.APRV_RJCT_ID)       AS APRV_RJCT_ID" ).append("\n"); 
		query.append("FROM   (SELECT I.VSL_SLAN_CD" ).append("\n"); 
		query.append(", I.VVD" ).append("\n"); 
		query.append(", I.BKG_NO" ).append("\n"); 
		query.append(", I.COD_RQST_RSN_CD" ).append("\n"); 
		query.append(", I.OLD_POL" ).append("\n"); 
		query.append(", I.OLD_POD" ).append("\n"); 
		query.append(", I.OLD_DEL" ).append("\n"); 
		query.append(", I.NEW_POL" ).append("\n"); 
		query.append(", I.NEW_POD" ).append("\n"); 
		query.append(", I.NEW_DEL" ).append("\n"); 
		query.append(", I.COD_RQST_OFC_CD" ).append("\n"); 
		query.append(", I.COD_STS_CD" ).append("\n"); 
		query.append(", ( SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("FROM   BKG_COD_COST C" ).append("\n"); 
		query.append("WHERE  I.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND    I.COD_RQST_SEQ = C.COD_RQST_SEQ ) CHG_AMT" ).append("\n"); 
		query.append(", I.DIFF_RMK" ).append("\n"); 
		query.append(", I.BL_NO" ).append("\n"); 
		query.append(", I.COD_RQST_SEQ" ).append("\n"); 
		query.append(", I.COD_RHND_PORT_CD" ).append("\n"); 
		query.append(", I.ACT_DEPT_YN" ).append("\n"); 
		query.append(", I.POD_ETA_DT" ).append("\n"); 
		query.append(", I.COD_EMAIL_SEND_YN" ).append("\n"); 
		query.append(", I.NEW_VSL_CD" ).append("\n"); 
		query.append(", I.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(", I.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(", I.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append("/* REQUESTED_DATE */" ).append("\n"); 
		query.append(",   (SELECT   MIN(HIS.CRE_DT)" ).append("\n"); 
		query.append("FROM     BKG_COD_HIS          HIS" ).append("\n"); 
		query.append("WHERE    HIS.BKG_NO           = I.BKG_NO" ).append("\n"); 
		query.append("AND      HIS.COD_RQST_SEQ     = I.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND      HIS.COD_STS_CD       = 'R'" ).append("\n"); 
		query.append(")    AS REQ_DT" ).append("\n"); 
		query.append("/* FIRST_REACT_DATE */" ).append("\n"); 
		query.append(",   (SELECT   MIN(HIS.CRE_DT)" ).append("\n"); 
		query.append("FROM     BKG_COD_HIS          HIS" ).append("\n"); 
		query.append("WHERE    HIS.BKG_NO           = I.BKG_NO" ).append("\n"); 
		query.append("AND      HIS.COD_RQST_SEQ     = I.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND      HIS.COD_STS_CD       <> 'R'" ).append("\n"); 
		query.append(")                             AS FIRST_REACT_DATE" ).append("\n"); 
		query.append(",   (SELECT   HIS.CRE_USR_ID" ).append("\n"); 
		query.append("FROM     BKG_COD_HIS          HIS" ).append("\n"); 
		query.append("WHERE    HIS.BKG_NO           = I.BKG_NO" ).append("\n"); 
		query.append("AND      HIS.COD_RQST_SEQ     = I.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND      HIS.COD_STS_CD       IN ('Y','N')" ).append("\n"); 
		query.append("AND      HIS.COD_HIS_SEQ      = (SELECT    MAX(HIST.COD_HIS_SEQ)" ).append("\n"); 
		query.append("FROM      BKG_COD_HIS        HIST" ).append("\n"); 
		query.append("WHERE     HIST.BKG_NO        = HIS.BKG_NO" ).append("\n"); 
		query.append("AND       HIST.COD_RQST_SEQ  = HIS.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND       HIST.COD_STS_CD    IN ('Y','N')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")                             AS APRV_RJCT_ID" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT VS.VSL_SLAN_CD" ).append("\n"); 
		query.append(", BC.OLD_VSL_CD||BC.OLD_SKD_VOY_NO||BC.OLD_SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", BC.BKG_NO" ).append("\n"); 
		query.append(", BC.COD_RQST_RSN_CD" ).append("\n"); 
		query.append(", SUBSTR(BC.OLD_POL_YD_CD, 1, 5) OLD_POL" ).append("\n"); 
		query.append(", SUBSTR(BC.OLD_POD_YD_CD, 1, 5) OLD_POD" ).append("\n"); 
		query.append(", SUBSTR(BC.OLD_DEL_YD_CD, 1, 5) OLD_DEL" ).append("\n"); 
		query.append(", SUBSTR(BC.NEW_POL_YD_CD, 1, 5) NEW_POL" ).append("\n"); 
		query.append(", SUBSTR(BC.NEW_POD_YD_CD, 1, 5) NEW_POD" ).append("\n"); 
		query.append(", SUBSTR(BC.NEW_DEL_YD_CD, 1, 5) NEW_DEL" ).append("\n"); 
		query.append(", BC.COD_RQST_OFC_CD" ).append("\n"); 
		query.append(", BC.COD_STS_CD" ).append("\n"); 
		query.append(", BC.DIFF_RMK" ).append("\n"); 
		query.append(", BB.BL_NO" ).append("\n"); 
		query.append(", MAX(BC.COD_RQST_SEQ) COD_RQST_SEQ" ).append("\n"); 
		query.append(", BC.COD_RHND_PORT_CD" ).append("\n"); 
		query.append(", DECODE(BC.COD_STS_CD, 'R', DECODE(VAPS.ACT_DEP_DT, NULL, 'Y', 'N'), 'Y') ACT_DEPT_YN" ).append("\n"); 
		query.append(", BB.POD_ETA_DT" ).append("\n"); 
		query.append(", CASE WHEN BB.POD_ETA_DT > SYSDATE THEN 'Y' ELSE 'N'" ).append("\n"); 
		query.append("END COD_EMAIL_SEND_YN" ).append("\n"); 
		query.append(", BC.NEW_VSL_CD" ).append("\n"); 
		query.append(", BC.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(", BC.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(", BC.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(", BC.CRE_DT     -- REQ_DT 로 변경" ).append("\n"); 
		query.append("FROM   BKG_COD BC ," ).append("\n"); 
		query.append("VSK_VSL_SKD VS ," ).append("\n"); 
		query.append("BKG_COD_CNTR BCN ," ).append("\n"); 
		query.append("BKG_BOOKING BB ," ).append("\n"); 
		query.append("VSK_ACT_PORT_SKD VAPS" ).append("\n"); 
		query.append("WHERE  BC.OLD_VSL_CD     = VS.VSL_CD(+)" ).append("\n"); 
		query.append("AND    BC.OLD_SKD_VOY_NO = VS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    BC.OLD_SKD_DIR_CD = VS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    BC.OLD_VSL_CD     = VAPS.VSL_CD(+)" ).append("\n"); 
		query.append("AND    BC.OLD_SKD_VOY_NO = VAPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    BC.OLD_SKD_DIR_CD = VAPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    SUBSTR(BC.OLD_POD_YD_CD, 1, 5) = VAPS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND    BC.RGN_CD         = @[rso]" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND    VS.VSL_SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    ( BC.OLD_VSL_CD     = @[vsl_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND    ( BC.OLD_SKD_VOY_NO = @[skd_voy_no] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND    ( BC.OLD_SKD_DIR_CD = @[skd_dir_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cod_sts_cd} != '')" ).append("\n"); 
		query.append("AND    BC.COD_STS_CD     = @[cod_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cod_rqst_rsn_cd} != 'All')" ).append("\n"); 
		query.append("AND    BC.COD_RQST_RSN_CD     = @[cod_rqst_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND    BC.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    DECODE(BC.COD_MNL_FLG, 'Y', 'Y', 'N') = 'N'" ).append("\n"); 
		query.append("AND    BCN.COD_SLCT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    BC.COD_STS_CD != 'M'" ).append("\n"); 
		query.append("AND    BC.BKG_NO = BCN.BKG_NO" ).append("\n"); 
		query.append("AND    BC.COD_RQST_SEQ = BCN.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("AND    BC.COD_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${fr_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("AND    BC.CRE_DT BETWEEN  TO_DATE(@[fr_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY VS.VSL_SLAN_CD" ).append("\n"); 
		query.append(", BC.OLD_VSL_CD||BC.OLD_SKD_VOY_NO||BC.OLD_SKD_DIR_CD" ).append("\n"); 
		query.append(", BC.BKG_NO" ).append("\n"); 
		query.append(", BC.COD_RQST_RSN_CD" ).append("\n"); 
		query.append(", BC.OLD_POL_YD_CD" ).append("\n"); 
		query.append(", BC.OLD_POD_YD_CD" ).append("\n"); 
		query.append(", BC.OLD_DEL_YD_CD" ).append("\n"); 
		query.append(", BC.NEW_POL_YD_CD" ).append("\n"); 
		query.append(", BC.NEW_POD_YD_CD" ).append("\n"); 
		query.append(", BC.NEW_DEL_YD_CD" ).append("\n"); 
		query.append(", BC.COD_RQST_OFC_CD" ).append("\n"); 
		query.append(", BC.COD_STS_CD" ).append("\n"); 
		query.append(", BC.DIFF_RMK" ).append("\n"); 
		query.append(", BB.BL_NO" ).append("\n"); 
		query.append(", BC.COD_RHND_PORT_CD" ).append("\n"); 
		query.append(", DECODE(BC.COD_STS_CD, 'R', DECODE(VAPS.ACT_DEP_DT, NULL, 'Y', 'N'), 'Y')" ).append("\n"); 
		query.append(", BB.POD_ETA_DT" ).append("\n"); 
		query.append(", BC.NEW_VSL_CD" ).append("\n"); 
		query.append(", BC.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(", BC.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(", BC.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(", BC.CRE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") I" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("BKG_COD_CNTR C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND    A.COD_RQST_SEQ = C.COD_RQST_SEQ" ).append("\n"); 
		query.append("/* COD Request 3일이내 데이터만 조회처리 */" ).append("\n"); 
		query.append("--AND    SYSDATE - GLOBALDATE_PKG.TIME_CONV_FNC(A.OLD_POL,A.COD_ISS_DT,'KRPUS') <= 3" ).append("\n"); 
		query.append("GROUP BY A.VSL_SLAN_CD" ).append("\n"); 
		query.append(", A.VVD" ).append("\n"); 
		query.append(", A.BKG_NO" ).append("\n"); 
		query.append(", A.COD_RQST_RSN_CD" ).append("\n"); 
		query.append(", A.OLD_POL" ).append("\n"); 
		query.append(", A.OLD_POD" ).append("\n"); 
		query.append(", A.OLD_DEL" ).append("\n"); 
		query.append(", A.NEW_POL" ).append("\n"); 
		query.append(", A.NEW_POD" ).append("\n"); 
		query.append(", A.NEW_DEL" ).append("\n"); 
		query.append(", A.COD_RQST_OFC_CD" ).append("\n"); 
		query.append(", A.COD_STS_CD" ).append("\n"); 
		query.append(", A.CHG_AMT" ).append("\n"); 
		query.append(", A.DIFF_RMK" ).append("\n"); 
		query.append(", A.BL_NO" ).append("\n"); 
		query.append(", A.COD_RQST_SEQ" ).append("\n"); 
		query.append(", A.COD_RHND_PORT_CD" ).append("\n"); 
		query.append(", A.ACT_DEPT_YN" ).append("\n"); 
		query.append(", A.POD_ETA_DT" ).append("\n"); 
		query.append(", A.COD_EMAIL_SEND_YN" ).append("\n"); 
		query.append(", A.NEW_VSL_CD" ).append("\n"); 
		query.append(", A.NEW_SKD_VOY_NO" ).append("\n"); 
		query.append(", A.NEW_SKD_DIR_CD" ).append("\n"); 
		query.append(", A.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append(", A.REQ_DT" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD, A.VVD, A.BKG_NO, A.COD_RQST_RSN_CD" ).append("\n"); 

	}
}