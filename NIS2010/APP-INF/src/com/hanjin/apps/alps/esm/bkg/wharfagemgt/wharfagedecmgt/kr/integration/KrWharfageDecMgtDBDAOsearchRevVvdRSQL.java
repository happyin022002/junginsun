/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchRevVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchRevVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchRevVvdRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchRevVvdRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUBSTR(AA,9), 'CNTC' ||" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYMM') ||" ).append("\n"); 
		query.append("'MM') AS REVENUE_VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(SUBSTR(TO_CHAR(n.RNK_SEQ,'999'),2)||n.RLANE_CD||q.vsl||q.voy_no||q.dep) AA" ).append("\n"); 
		query.append("FROM AR_ROUT_RNK n," ).append("\n"); 
		query.append("(       SELECT v.RLANE_CD rev_lane, t.vsl, t.voy_no, t.dep, t.lane, t.sconti_cd, t.zone_ioc" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD  v," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT vsl, voy_no, NVL(RLANE_DIR_CD,dep||dep) dep," ).append("\n"); 
		query.append("DECODE(vsl, 'COMC','COM','CNTC','CNT', DECODE(lane,'SYS','RBC',lane) ) lane, b.sconti_cd, zone_ioc" ).append("\n"); 
		query.append("FROM AR_FINC_DIR_CONV c," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select lane, vsl, voy_no, dep, pol, pod, sconti_cd, zone_ioc" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select lane, vsl, voy_no, dep, pol, pod, MIN(sconti_cd)sconti_cd," ).append("\n"); 
		query.append("DECODE(MIN(pol_conti)||MIN(pod_conti), 'AA','IA', 'EE','IE','MM','IM','EF','IE','FE','IE','FF','IE','OO') zone_ioc" ).append("\n"); 
		query.append("from        (" ).append("\n"); 
		query.append("SELECT v.SLAN_CD lane, v.VSL_CD vsl, v.SKD_VOY_NO voy_no, v.SKD_DIR_CD dep," ).append("\n"); 
		query.append("v.POL_CD pol, v.POD_CD pod, l.CONTI_CD pol_conti, NULL pod_conti, l.SCONTI_CD sconti_cd" ).append("\n"); 
		query.append("FROM BKG_VVD v, MDM_LOCATION l, ( SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', WHF_POL_CD, WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND WHF_BL_STS_CD != 'D' ) b" ).append("\n"); 
		query.append("WHERE v.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("AND v.POL_CD = l.loc_cd" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT v.SLAN_CD lane, v.VSL_CD vsl, v.SKD_VOY_NO voy_no, v.SKD_DIR_CD dep," ).append("\n"); 
		query.append("v.POL_CD pol, v.POD_CD pod, NULL pol_conti, l.CONTI_CD pod_conti, NULL sconti_cd" ).append("\n"); 
		query.append("FROM BKG_VVD v, MDM_LOCATION l, ( SELECT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_BL" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND WHF_BND_CD = @[whf_bnd_cd]" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', WHF_POL_CD, WHF_POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND WHF_BL_STS_CD != 'D' ) B" ).append("\n"); 
		query.append("WHERE v.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("AND v.POD_CD = l.loc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("group by lane, vsl, voy_no, dep, pol, pod )" ).append("\n"); 
		query.append("where sconti_cd is not null" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append("WHERE c.SLAN_CD(+) = b.lane" ).append("\n"); 
		query.append("AND  c.SLAN_DIR_CD(+) = b.dep" ).append("\n"); 
		query.append("AND  c.AP_MK_FLG(+) <> 'Y'" ).append("\n"); 
		query.append("AND  c.SCONTI_CD(+) = b.sconti_cd )t" ).append("\n"); 
		query.append("WHERE v.VSL_CD= t.vsl" ).append("\n"); 
		query.append("AND   v.SKD_VOY_NO = t.voy_no" ).append("\n"); 
		query.append("AND   v.SKD_DIR_CD = t.dep ) q" ).append("\n"); 
		query.append("WHERE n.RLANE_CD = q.rev_lane" ).append("\n"); 
		query.append("AND   n.SLAN_CD = q.lane" ).append("\n"); 
		query.append("AND   SUBSTR(n.ZN_IOC_CD,1,2) = q.zone_ioc )" ).append("\n"); 

	}
}