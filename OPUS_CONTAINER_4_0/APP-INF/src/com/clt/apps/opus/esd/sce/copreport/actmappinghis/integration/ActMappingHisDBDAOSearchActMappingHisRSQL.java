/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ActMappingHisDBDAOSearchActMappingHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2011.03.08 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.actmappinghis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeYoonJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActMappingHisDBDAOSearchActMappingHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchActMappingHis
	  * </pre>
	  */
	public ActMappingHisDBDAOSearchActMappingHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_umch_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("i_page",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copreport.actmappinghis.integration").append("\n"); 
		query.append("FileName : ActMappingHisDBDAOSearchActMappingHisRSQL").append("\n"); 
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
		query.append("SELECT ACT_RCV_TP_CD,ACT_UMCH_TP_CD,ACT_STS_MAPG_CD,ACT_DT,ACT_STS_MAPG_CD, VVD, BKG_NO ,ACT_GAP_DESC," ).append("\n"); 
		query.append("CNTR_NO,COP_NO,ACT_CD,NOD_CD,PLN_DT,ESTM_DT,MST_COP_NO,ACT_DAT_RCV_DT,UMCH_CHK_DT,DUP_FLG," ).append("\n"); 
		query.append("UPD_DT,UPD_USR_ID,PAGE" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("--SELECT CASE WHEN B.ACT_RCV_TP_CD ='1' THEN 'MVMT'" ).append("\n"); 
		query.append("--     WHEN B.ACT_RCV_TP_CD ='2' THEN 'VSL'" ).append("\n"); 
		query.append("--   WHEN B.ACT_RCV_TP_CD ='3' THEN '322'" ).append("\n"); 
		query.append("--   WHEN B.ACT_RCV_TP_CD ='4' THEN '214'" ).append("\n"); 
		query.append("--   WHEN B.ACT_RCV_TP_CD ='5' THEN 'SPP'" ).append("\n"); 
		query.append("--   WHEN B.ACT_RCV_TP_CD ='6' THEN 'Manual'" ).append("\n"); 
		query.append("--   ELSE B.ACT_RCV_TP_CD  END  ACT_RCV_TP_CD," ).append("\n"); 
		query.append("(SELECT d.ACT_RCV_TP_DESC FROM SCE_ACT_RCV_DESC d WHERE d.ACT_RCV_TP_CD = b.ACT_RCV_TP_CD) ACT_RCV_TP_CD," ).append("\n"); 
		query.append("DECODE(B.ACT_UMCH_TP_CD,'99','Y','N') ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(B.ACT_DT,'YYYY/MM/DD HH24:MI:SS') ACT_DT," ).append("\n"); 
		query.append("B.ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("--        C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD  VVD," ).append("\n"); 
		query.append("B.BKG_NO," ).append("\n"); 
		query.append("B.ACT_GAP_DESC," ).append("\n"); 
		query.append("B.CNTR_NO," ).append("\n"); 
		query.append("B.COP_NO," ).append("\n"); 
		query.append("B.ACT_CD," ).append("\n"); 
		query.append("B.NOD_CD ," ).append("\n"); 
		query.append("TO_CHAR(C.PLN_DT,'YYYY/MM/DD HH24:MI:SS') PLN_DT," ).append("\n"); 
		query.append("TO_CHAR(C.ESTM_DT,'YYYY/MM/DD HH24:MI:SS') ESTM_DT," ).append("\n"); 
		query.append("B.MST_COP_NO," ).append("\n"); 
		query.append("TO_CHAR(C.ACT_DAT_RCV_DT,'YYYY/MM/DD HH24:MI:SS') ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("TO_CHAR(B.UMCH_CHK_DT,'YYYY/MM/DD HH24:MI:SS') UMCH_CHK_DT," ).append("\n"); 
		query.append("B.DUP_FLG," ).append("\n"); 
		query.append("TO_CHAR(B.UPD_DT,'YYYY/MM/DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("CEIL(rownum/3000) PAGE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_HIS B, SCE_COP_DTL C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE C.cop_no(+) = B.cop_no" ).append("\n"); 
		query.append("AND C.act_cd(+) = B.act_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - ACT_RCV_TP_CD */" ).append("\n"); 
		query.append("#if (${act_rcv_tp_cd} != '')" ).append("\n"); 
		query.append("AND B.ACT_RCV_TP_CD =  @[act_rcv_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - act_sts_mapg_cd */" ).append("\n"); 
		query.append("#if (${act_sts_mapg_cd} != '')" ).append("\n"); 
		query.append("AND B.ACT_STS_MAPG_CD =  @[act_sts_mapg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - act_umch_tp_cd */" ).append("\n"); 
		query.append("#if (${act_umch_tp_cd} != '')" ).append("\n"); 
		query.append("AND DECODE(B.ACT_UMCH_TP_CD,'99','Y','N') =  @[act_umch_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - act_fm_dt */" ).append("\n"); 
		query.append("#if (${act_fm_dt} != '')" ).append("\n"); 
		query.append("AND B.act_rcv_dt BETWEEN REPLACE(@[act_fm_dt],'-') AND  REPLACE(@[act_to_dt],'-')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - bkg_no */" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND B.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - cntr_no */" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND B.CNTR_NO =  @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - cop_no */" ).append("\n"); 
		query.append("#if (${cop_no} != '')" ).append("\n"); 
		query.append("AND B.COP_NO =  @[cop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - vvd */" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - por_cd */" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND SUBSTR(B.NOD_CD,1,5) IN (SELECT POR_NOD_CD FROM SCE_COP_HDR WHERE COP_NO = B.COP_NO  AND POR_NOD_CD  IN(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($ele IN ${por_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - pol_cd */" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND SUBSTR(B.NOD_CD,1,5) IN (SELECT POL_NOD_CD FROM SCE_COP_HDR WHERE COP_NO = B.COP_NO  AND POL_NOD_CD  IN(" ).append("\n"); 
		query.append("#foreach($ele IN ${pol_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - pod_cd */" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND SUBSTR(B.NOD_CD,1,5) IN (SELECT POD_NOD_CD FROM SCE_COP_HDR WHERE COP_NO = B.COP_NO  AND POD_NOD_CD  IN(" ).append("\n"); 
		query.append("#foreach($ele IN ${pod_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - del_cd */" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND SUBSTR(B.NOD_CD,1,5) IN (SELECT DEL_NOD_CD FROM SCE_COP_HDR WHERE COP_NO = B.COP_NO  AND DEL_NOD_CD  IN(" ).append("\n"); 
		query.append("#foreach($ele IN ${del_cd})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${i_page} !='')" ).append("\n"); 
		query.append("AND PAGE = TO_NUMBER(@[i_page])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND PAGE =1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}