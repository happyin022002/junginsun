/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopVvdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.29 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopVvdInfo
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopVvdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopVvdInfoRSQL").append("\n"); 
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
		query.append("SELECT S2.COP_NO, S2.COP_DTL_SEQ, S2.NOD_CD, S2.ACT_CD, S2.ESTM_GAP, S2.VL_ROW, S2.TRNK_COP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT S1.COP_NO" ).append("\n"); 
		query.append(",MAX(DECODE(S1.SLT_FLG,'Y',S1.COP_DTL_SEQ)) COP_DTL_SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(S1.SLT_FLG,'Y',S1.NOD_CD)) NOD_CD" ).append("\n"); 
		query.append(",MAX(DECODE(S1.SLT_FLG,'Y',S1.ACT_CD)) ACT_CD" ).append("\n"); 
		query.append(",MAX(DECODE(S1.SLT_FLG,'Y',S1.ESTM_GAP)) ESTM_GAP" ).append("\n"); 
		query.append(",MIN(S1.VL_ROW) VL_ROW" ).append("\n"); 
		query.append(",NVL(MIN(S1.TRNK_COP),'N') TRNK_COP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.COP_NO" ).append("\n"); 
		query.append(",A.COP_DTL_SEQ" ).append("\n"); 
		query.append(",A.NOD_CD" ).append("\n"); 
		query.append(",A.ACT_CD" ).append("\n"); 
		query.append(",ROUND(TO_DATE(P_ACT_DT,'YYYY/MM/DD HH24:MI:SS') - A.ESTM_DT, 5) ESTM_GAP" ).append("\n"); 
		query.append(",A.COP_NO||A.COP_DTL_SEQ VL_ROW" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(A.ACT_CD,5,1) = SUBSTR(@[in_act_sts_mapg_cd],3,1) THEN 'Y' ELSE 'N' END) SLT_FLG" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(A.ACT_CD,5,1) = SUBSTR(@[in_act_sts_mapg_cd],3,1)" ).append("\n"); 
		query.append("THEN (SELECT MIN(SC.COP_NO||SC.COP_DTL_SEQ)" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL SC" ).append("\n"); 
		query.append("WHERE  SC.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("AND    (SC.VSL_CD||SC.SKD_VOY_NO||SC.SKD_DIR_CD) = SUBSTR((SELECT MIN(SG.COP_DTL_SEQ||SG.VSL_CD||SG.SKD_VOY_NO||SG.SKD_DIR_CD)" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL SG" ).append("\n"); 
		query.append("WHERE  SG.COP_NO      = A.COP_NO" ).append("\n"); 
		query.append("AND    SUBSTR(SG.ACT_CD,3,1) = 'V'" ).append("\n"); 
		query.append("AND    SG.COP_DTL_SEQ > (SELECT MAX(SSG.COP_DTL_SEQ) FROM SCE_COP_DTL SSG" ).append("\n"); 
		query.append("WHERE SSG.COP_NO    = B.COP_NO" ).append("\n"); 
		query.append("AND SUBSTR(SSG.ACT_CD,3,1) = 'V'" ).append("\n"); 
		query.append("AND (SSG.VSL_CD||SSG.SKD_VOY_NO||SSG.SKD_DIR_CD||SSG.VPS_PORT_CD) = (@[in_vsl_cd]||@[in_skd_voy_no]||@[in_skd_dir_cd]||@[in_vps_port_cd]))" ).append("\n"); 
		query.append("),5,9)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END) TRNK_COP" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL A, SCE_COP_HDR B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD                = @[in_vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO            = @[in_skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD            = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("AND    SUBSTR(A.NOD_CD,1,5)    = @[in_vps_port_cd]" ).append("\n"); 
		query.append("AND    NVL(A.CLPT_IND_SEQ,'1') = NVL(@[in_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("AND    B.COP_NO                = A.COP_NO" ).append("\n"); 
		query.append("AND    B.COP_STS_CD            IN ('C','T') ) S1" ).append("\n"); 
		query.append("GROUP BY COP_NO ) S2" ).append("\n"); 
		query.append("WHERE SUBSTR(S2.ACT_CD,5,1) = SUBSTR(@[in_act_sts_mapg_cd],3,1)" ).append("\n"); 

	}
}