/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfCntrPortRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.13 
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

public class KrWharfageDecMgtDBDAOsearchKrWhfCntrPortRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfCntrPortRtRSQL(){
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
		params.put("whf_vol_dc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfCntrPortRtRSQL").append("\n"); 
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
		query.append("SELECT A.TEU_PRC * (1 - A.TEU_AMT_RT) AS CNTR_20_UT_RT," ).append("\n"); 
		query.append("       A.FEU_PRC * (1 - A.FEU_AMT_RT) AS CNTR_40_UT_RT," ).append("\n"); 
		query.append("       A.HC_PRC * (1 - A.HC_AMT_RT) AS CNTR_45_UT_RT" ).append("\n"); 
		query.append("  FROM BKG_KR_WHF_PORT_RT A, VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append(" WHERE A.CNTR_BLK_DIV_CD = 'C'" ).append("\n"); 
		query.append("   AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("   AND A.DC_RTO_NO = (SELECT NVL(TRIM(MAX(B.DC_RTO_NO)), '0')" ).append("\n"); 
		query.append("                        FROM BKG_KR_WHF_PORT_RT B" ).append("\n"); 
		query.append("                       WHERE B.CNTR_BLK_DIV_CD = A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("                         AND B.PORT_CD = A.PORT_CD" ).append("\n"); 
		query.append("                         AND B.DC_RTO_NO = @[whf_vol_dc_cd])" ).append("\n"); 
		query.append("   AND S.VSL_CD = SUBSTR( @[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND S.SKD_VOY_NO = SUBSTR( @[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND S.SKD_DIR_CD = SUBSTR( @[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND S.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND S.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("   AND DECODE( SUBSTR(@[whf_bnd_cd],1,1), 'I', S.VPS_ETA_DT, S.VPS_ETD_DT) BETWEEN A.EFF_FM_DT AND A.EFF_TO_DT + 0.99999" ).append("\n"); 

	}
}