/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOSearchVvdTimeInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchVvdTimeInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for cusor - search_vvd_time_information
	  * </pre>
	  */
	public Edi315SendDBDAOSearchVvdTimeInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchVvdTimeInformationRSQL").append("\n"); 
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
		query.append("      NVL(a.vsl_cd, ' ')||NVL(a.skd_voy_no, ' ')||NVL(a.skd_dir_cd, ' ') BVVD1," ).append("\n"); 
		query.append("      b.OB_CSSM_VOY_NO VSL_CONSORT_VOY_NO, --NEW" ).append("\n"); 
		query.append("      NVL(decode(D.CALL_SGN_NO, 'T.B.N.', 'TBN', D.CALL_SGN_NO), ' ') VSL_CALLSIGN1," ).append("\n"); 
		query.append("      NVL(decode(D.LLOYD_NO, 'T.B.N.', 'TBN', D.LLOYD_NO), ' ') VSL_LLOYDCODE1," ).append("\n"); 
		query.append("      NVL(REPLACE(D.VSL_ENG_NM, CHR(39), ' '), ' ') VSL_FULLNAME1," ).append("\n"); 
		query.append("      D.vsl_rgst_cnt_cd VSL_CNT_CD,  --NEW" ).append("\n"); 
		query.append("      NVL(a.pol_cd, ' ') BLPOL1," ).append("\n"); 
		query.append("      DECODE(E.CNT_CD, 'US', 'D', 'K') POL_AMSQUAL1, --NEW" ).append("\n"); 
		query.append("      E.LOC_AMS_PORT_CD POL_AMSPORT1, --NEW" ).append("\n"); 
		query.append("      e.LOC_NM POL_FULLNAME1," ).append("\n"); 
		query.append("      NVL(a.pod_cd, ' ') BLPOD1," ).append("\n"); 
		query.append("      DECODE(F.CNT_CD, 'US', 'D', 'K') POD_AMSQUAL1, --NEW" ).append("\n"); 
		query.append("      F.LOC_AMS_PORT_CD POD_AMSPORT1, --NEW" ).append("\n"); 
		query.append("      f.LOC_NM POD_FULLNAME1," ).append("\n"); 
		query.append("      NVL(TO_CHAR(b.VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ') POLETA1," ).append("\n"); 
		query.append("      DECODE(b.VPS_PORT_CD, NULL, ' ', DECODE(b.VPS_ETA_DT, NULL, ' ', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(b.VPS_PORT_CD, b.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI'))) POLETA1_GMT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      NVL(CASE WHEN b.PORT_SKD_STS_CD IN ('A','B','D') THEN TO_CHAR(b.VPS_ETA_DT, 'YYYYMMDDHH24MI') ELSE ' ' END, ' ') POLATA1," ).append("\n"); 
		query.append("	  DECODE(b.VPS_PORT_CD, NULL, ' ', CASE WHEN b.PORT_SKD_STS_CD IN ('A','B','D') THEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(b.VPS_PORT_CD, b.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI') ELSE ' ' END) POLATA1_GMT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      NVL(TO_CHAR(b.VPS_ETD_DT, 'YYYYMMDDHH24MI'), ' ') POLETD1," ).append("\n"); 
		query.append("      DECODE(b.VPS_PORT_CD, NULL, ' ', DECODE(b.VPS_ETD_DT, NULL, ' ', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(b.VPS_PORT_CD, b.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI'))) POLETD1_GMT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      NVL(DECODE(b.PORT_SKD_STS_CD,'D',TO_CHAR(b.VPS_ETD_DT, 'YYYYMMDDHH24MI'),' '), ' ') POLATD1," ).append("\n"); 
		query.append("      DECODE(b.VPS_PORT_CD, NULL, ' ', DECODE(b.PORT_SKD_STS_CD, 'D', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(b.VPS_PORT_CD, b.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI'),' ')) POLATD1_GMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      NVL(TO_CHAR(c.VPS_ETA_DT, 'YYYYMMDDHH24MI'), ' ') PODETA1," ).append("\n"); 
		query.append("      DECODE(c.VPS_PORT_CD, NULL, ' ', DECODE(c.VPS_ETA_DT, NULL, ' ', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(c.VPS_PORT_CD, c.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI'))) PODETA1_GMT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      NVL(CASE WHEN c.PORT_SKD_STS_CD IN ('A','B','D') THEN TO_CHAR(c.VPS_ETA_DT, 'YYYYMMDDHH24MI') ELSE ' ' END, ' ') PODATA1," ).append("\n"); 
		query.append("	  DECODE(c.VPS_PORT_CD, NULL, ' ', CASE WHEN c.PORT_SKD_STS_CD IN ('A','B','D') THEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(c.VPS_PORT_CD, c.VPS_ETA_DT, 'GMT'), 'YYYYMMDDHH24MI') ELSE ' ' END) PODATA1_GMT," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      NVL(TO_CHAR(c.VPS_ETD_DT, 'YYYYMMDDHH24MI'), ' ') PODETD1," ).append("\n"); 
		query.append("      DECODE(c.VPS_PORT_CD, NULL, ' ', DECODE(c.VPS_ETD_DT, NULL, ' ', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(c.VPS_PORT_CD, c.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI'))) PODETD1_GMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      NVL(DECODE(c.PORT_SKD_STS_CD,'D',TO_CHAR(c.VPS_ETD_DT, 'YYYYMMDDHH24MI'),' '), ' ') PODATD1," ).append("\n"); 
		query.append("      DECODE(c.VPS_PORT_CD, NULL, ' ', DECODE(c.PORT_SKD_STS_CD,'D', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(c.VPS_PORT_CD, c.VPS_ETD_DT, 'GMT'), 'YYYYMMDDHH24MI'),' ')) PODATD1_GMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      a.slan_cd bv_lane" ).append("\n"); 
		query.append("    FROM bkg_vvd a," ).append("\n"); 
		query.append("      vsk_vsl_port_skd b," ).append("\n"); 
		query.append("      vsk_vsl_port_skd c," ).append("\n"); 
		query.append("      MDM_VSL_CNTR d," ).append("\n"); 
		query.append("      mdm_location e," ).append("\n"); 
		query.append("      mdm_location f" ).append("\n"); 
		query.append("    WHERE a.bkg_no = @[e_bkg_no] " ).append("\n"); 
		query.append("      AND a.vsl_cd = b.vsl_cd(+)" ).append("\n"); 
		query.append("      AND a.skd_voy_no = b.skd_voy_no(+)" ).append("\n"); 
		query.append("      AND a.skd_dir_cd = b.skd_dir_cd(+)" ).append("\n"); 
		query.append("      AND a.pol_cd = b.vps_port_cd(+)" ).append("\n"); 
		query.append("      --AND b.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("      AND a.vsl_cd = c.vsl_cd(+)" ).append("\n"); 
		query.append("      AND a.skd_voy_no = c.skd_voy_no(+)" ).append("\n"); 
		query.append("      AND a.skd_dir_cd = c.skd_dir_cd(+)" ).append("\n"); 
		query.append("      AND a.pod_cd = c.vps_port_cd(+)" ).append("\n"); 
		query.append("      --AND c.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("      AND a.vsl_cd = d.vsl_cd(+)" ).append("\n"); 
		query.append("      AND a.pol_cd = e.loc_cd(+)" ).append("\n"); 
		query.append("      AND a.pod_cd = f.loc_cd(+)" ).append("\n"); 
		query.append("      AND a.POL_CLPT_IND_SEQ = b.CLPT_IND_SEQ -- 조건 추가" ).append("\n"); 
		query.append("      AND a.POD_CLPT_IND_SEQ = c.CLPT_IND_SEQ -- 조건 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY BKG_NO, VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}