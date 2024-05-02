/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfPortRtListOAKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfPortRtListOAKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfPortRtListOAK
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfPortRtListOAKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfPortRtListOAKRSQL").append("\n"); 
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
		query.append("SELECT TB.*, @[port] PORT, @[bound] BOUND, @[eff_dt] EFF_DT" ).append("\n"); 
		query.append(",'' AS LOCAL_PRC" ).append("\n"); 
		query.append(",'' AS RAIL_PRC" ).append("\n"); 
		query.append(",'' AS TS_PRC" ).append("\n"); 
		query.append(",'N' USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",'' USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",'' WHF_DC_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '1' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '20F', WHF_UT_PRC)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '40F', WHF_UT_PRC)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '45F', WHF_UT_PRC)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'CON', WHF_UT_PRC)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'TEU', WHF_UT_PRC)) AS teus" ).append("\n"); 
		query.append(",'F' FULL_MTY_CD" ).append("\n"); 
		query.append(",'L' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL RT_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND RT_DTL.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND RT_DTL.EFF_DT = TO_DATE(@[eff_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '20F', WHF_UT_PRC)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '40F', WHF_UT_PRC)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '45F', WHF_UT_PRC)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'CON', WHF_UT_PRC)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'TEU', WHF_UT_PRC)) AS teus" ).append("\n"); 
		query.append(",'M' FULL_MTY_CD" ).append("\n"); 
		query.append(",'L' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL RT_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND RT_DTL.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND RT_DTL.EFF_DT = TO_DATE(@[eff_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '20F', WHF_UT_PRC)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '40F', WHF_UT_PRC)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '45F', WHF_UT_PRC)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'CON', WHF_UT_PRC)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'TEU', WHF_UT_PRC)) AS teus" ).append("\n"); 
		query.append(",'F' FULL_MTY_CD" ).append("\n"); 
		query.append(",'I' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL RT_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND RT_DTL.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND RT_DTL.EFF_DT = TO_DATE(@[eff_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'I'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '4' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '20F', WHF_UT_PRC)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '40F', WHF_UT_PRC)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, '45F', WHF_UT_PRC)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'CON', WHF_UT_PRC)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(RT_DTL.USA_WHF_RAT_UT_CD, 'TEU', WHF_UT_PRC)) AS teus" ).append("\n"); 
		query.append(",'M' FULL_MTY_CD" ).append("\n"); 
		query.append(",'I' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL RT_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND RT_DTL.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND RT_DTL.EFF_DT = TO_DATE(@[eff_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'I'" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 

	}
}