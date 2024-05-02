/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckBKGscheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckBKGscheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check BKG schedule
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckBKGscheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pre_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckBKGscheduleRSQL").append("\n"); 
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
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT /*+ ORDERED USE_NL(BK B1 VVD1 VVD2 SKD1 SKD2) */" ).append("\n"); 
		query.append("               SKD1.VPS_PORT_CD POL_PORT" ).append("\n"); 
		query.append("               , SKD2.VPS_PORT_CD POD_PORT" ).append("\n"); 
		query.append("               , ROW_NUMBER() OVER( ORDER BY VVD1.VSL_PRE_PST_CD, VVD1.VSL_SEQ, SKD1.CLPT_SEQ) ROW_SEQ" ).append("\n"); 
		query.append("               , SKD1.CLPT_SEQ AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("               , SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("               , SKD1.VPS_ETD_DT" ).append("\n"); 
		query.append("               , SKD2.VPS_ETA_DT" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("               , BKG_BOOKING B1" ).append("\n"); 
		query.append("               , BKG_VVD VVD1" ).append("\n"); 
		query.append("               , BKG_VVD VVD2" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND Bk.BKG_NO = @[pre_bkg_no]" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("           AND VVD1.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("           AND VVD1.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD1.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("           AND VVD2.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("           AND VVD2.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD2.SKD_DIR_CD = BK.SKD_DIR_CD  " ).append("\n"); 
		query.append("           AND VVD1.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("           AND VVD1.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD1.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD1.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD1.POL_CLPT_IND_SEQ  = SKD1.CLPT_IND_SEQ " ).append("\n"); 
		query.append("           AND VVD2.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("           AND VVD2.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD2.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD2.POD_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD2.POD_CLPT_IND_SEQ  = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND NVL(SKD1.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(SKD2.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       (SELECT /*+ ORDERED USE_NL(BK VVD1 VVD2 SKD1 SKD2) */" ).append("\n"); 
		query.append("               SKD1.VPS_PORT_CD POL_PORT" ).append("\n"); 
		query.append("               , SKD2.VPS_PORT_CD POD_PORT" ).append("\n"); 
		query.append("               , ROW_NUMBER() OVER( ORDER BY VVD1.VSL_PRE_PST_CD, VVD1.VSL_SEQ, SKD1.CLPT_SEQ) ROW_SEQ" ).append("\n"); 
		query.append("               , SKD1.CLPT_SEQ AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("               , SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("               , SKD1.VPS_ETD_DT" ).append("\n"); 
		query.append("               , SKD2.VPS_ETA_DT" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("               , BKG_VVD VVD1" ).append("\n"); 
		query.append("               , BKG_VVD VVD2" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("           AND VVD1.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("           AND VVD1.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD1.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("           AND VVD2.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("           AND VVD2.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD2.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("           AND VVD1.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("           AND VVD1.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD1.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD1.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD1.POL_CLPT_IND_SEQ  = SKD1.CLPT_IND_SEQ " ).append("\n"); 
		query.append("           AND VVD2.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("           AND VVD2.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD2.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD2.POD_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD2.POD_CLPT_IND_SEQ  = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND NVL(SKD1.SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("           AND NVL(SKD2.SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE A.POL_CLPT_SEQ < B.POD_CLPT_SEQ" ).append("\n"); 
		query.append("   AND A.POD_CLPT_SEQ > B.POL_CLPT_SEQ" ).append("\n"); 
		query.append("   AND ROWNUM =1" ).append("\n"); 

	}
}