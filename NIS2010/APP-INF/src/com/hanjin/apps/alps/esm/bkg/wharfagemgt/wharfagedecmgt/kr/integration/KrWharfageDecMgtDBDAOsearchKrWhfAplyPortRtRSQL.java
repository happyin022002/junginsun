/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfAplyPortRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.21 
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

public class KrWharfageDecMgtDBDAOsearchKrWhfAplyPortRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfAplyPortRtRSQL(){
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
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfAplyPortRtRSQL").append("\n"); 
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
		query.append("SELECT B.TEU_PRC * (1 - B.TEU_AMT_RT) AS KR_WHF_CNTR_20FT_RT," ).append("\n"); 
		query.append("       B.FEU_PRC * (1 - B.FEU_AMT_RT) AS KR_WHF_CNTR_40FT_RT," ).append("\n"); 
		query.append("       B.HC_PRC * (1 - B.HC_AMT_RT) AS KR_WHF_CNTR_45FT_RT," ).append("\n"); 
		query.append("       C.TEU_PRC * (1 - C.TEU_AMT_RT) AS KR_WHF_BLK_RT" ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("           U.WHF_VOL_DC_CD WHF_VOL_DC_CD," ).append("\n"); 
		query.append("           S.VPS_ETA_DT VPS_ETA_DT," ).append("\n"); 
		query.append("           S.VPS_ETD_DT VPS_ETD_DT" ).append("\n"); 
		query.append("      FROM BKG_KR_WHF_VOL U," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("      WHERE U.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND U.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND U.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND U.PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("      AND SUBSTR(U.WHF_BND_CD(+), 1, 1) = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("      AND S.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("      and S.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("      AND ROWNUM =1" ).append("\n"); 
		query.append("      ) A, " ).append("\n"); 
		query.append("      BKG_KR_WHF_PORT_RT B, " ).append("\n"); 
		query.append("      BKG_KR_WHF_PORT_RT C" ).append("\n"); 
		query.append("WHERE B.CNTR_BLK_DIV_CD(+) = 'C'" ).append("\n"); 
		query.append("AND B.PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("AND B.IO_BND_CD(+) = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("AND B.DC_RTO_NO(+) = A.WHF_VOL_DC_CD" ).append("\n"); 
		query.append("AND C.CNTR_BLK_DIV_CD(+) = 'B'" ).append("\n"); 
		query.append("AND C.PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("AND C.IO_BND_CD(+) = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("AND C.DC_RTO_NO(+) = A.WHF_VOL_DC_CD" ).append("\n"); 
		query.append("AND decode( SUBSTR(@[whf_bnd_cd], 1, 1), 'I', A.VPS_ETA_DT, A.VPS_ETD_DT) BETWEEN B.EFF_FM_DT(+) AND B.EFF_TO_DT(+) + 0.99999" ).append("\n"); 
		query.append("AND decode( SUBSTR(@[whf_bnd_cd], 1, 1), 'I', A.VPS_ETA_DT, A.VPS_ETD_DT) BETWEEN C.EFF_FM_DT(+) AND C.EFF_TO_DT(+) + 0.99999" ).append("\n"); 

	}
}