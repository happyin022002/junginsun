/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendQtyUSOAKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.14 김민정
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

public class UsWharfageDecMgtDBDAOsearchUsWhfSendQtyUSOAKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendQtyUSOAK
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendQtyUSOAKRSQL(){
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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendQtyUSOAKRSQL").append("\n"); 
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
		query.append("WITH RT_DTL AS (" ).append("\n"); 
		query.append("SELECT USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",FULL_MTY_CD" ).append("\n"); 
		query.append(",USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",WHF_UT_PRC" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL DTL" ).append("\n"); 
		query.append(",(SELECT MAX(EFF_DT) AS EFF_DT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append(") MAX_RT" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND DTL.EFF_DT = MAX_RT.EFF_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TB.*" ).append("\n"); 
		query.append(",MAX(DECODE(B.USA_WHF_RAT_UT_CD, '20F', B.WHF_UT_PRC)) AS UT_PRC_20FT" ).append("\n"); 
		query.append(",MAX(DECODE(B.USA_WHF_RAT_UT_CD, '40F', B.WHF_UT_PRC)) AS UT_PRC_40FT" ).append("\n"); 
		query.append(",MAX(DECODE(B.USA_WHF_RAT_UT_CD, '45F', B.WHF_UT_PRC)) AS UT_PRC_45FT" ).append("\n"); 
		query.append(",MAX(DECODE(B.USA_WHF_RAT_UT_CD, 'CON', B.WHF_UT_PRC)) AS UT_PRC_CONT" ).append("\n"); 
		query.append(",MAX(DECODE(B.USA_WHF_RAT_UT_CD, 'TEU', B.WHF_UT_PRC)) AS UT_PRC_TEUS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '1' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '20F', RAT_AS_QTY)) AS FT20" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '40F', RAT_AS_QTY)) AS FT40" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '45F', RAT_AS_QTY)) AS FT45" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'CON', RAT_AS_QTY)) AS CONT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'TEU', RAT_AS_QTY)) AS TEUS" ).append("\n"); 
		query.append(",SUM(RAT_AS_QTY * WHF_UT_PRC) AS WHF_AMT" ).append("\n"); 
		query.append(",'F' FULL_MTY_CD" ).append("\n"); 
		query.append(",'L' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '20F', RAT_AS_QTY)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '40F', RAT_AS_QTY)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '45F', RAT_AS_QTY)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'CON', RAT_AS_QTY)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'TEU', RAT_AS_QTY)) AS teus" ).append("\n"); 
		query.append(",SUM(RAT_AS_QTY * WHF_UT_PRC) AS WHF_AMT" ).append("\n"); 
		query.append(",'M' FULL_MTY_CD" ).append("\n"); 
		query.append(",'L' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '20F', RAT_AS_QTY)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '40F', RAT_AS_QTY)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '45F', RAT_AS_QTY)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'CON', RAT_AS_QTY)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'TEU', RAT_AS_QTY)) AS teus" ).append("\n"); 
		query.append(",SUM(RAT_AS_QTY * WHF_UT_PRC) AS WHF_AMT" ).append("\n"); 
		query.append(",'F' FULL_MTY_CD" ).append("\n"); 
		query.append(",'I' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'I'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '4' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '20F', RAT_AS_QTY)) AS ft20" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '40F', RAT_AS_QTY)) AS ft40" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, '45F', RAT_AS_QTY)) AS ft45" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'CON', RAT_AS_QTY)) AS cont" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_RAT_UT_CD, 'TEU', RAT_AS_QTY)) AS teus" ).append("\n"); 
		query.append(",SUM(RAT_AS_QTY * WHF_UT_PRC) AS WHF_AMT" ).append("\n"); 
		query.append(",'M' FULL_MTY_CD" ).append("\n"); 
		query.append(",'I' USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'I'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append(",RT_DTL B" ).append("\n"); 
		query.append("WHERE B.FULL_MTY_CD = TB.FULL_MTY_CD(+)" ).append("\n"); 
		query.append("AND B.USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.USA_WHF_TRSP_TP_CD = TB.USA_WHF_TRSP_TP_CD(+)" ).append("\n"); 
		query.append("GROUP BY TB.SEQ" ).append("\n"); 
		query.append(",TB.ft20" ).append("\n"); 
		query.append(",TB.ft40" ).append("\n"); 
		query.append(",TB.ft45" ).append("\n"); 
		query.append(",TB.cont" ).append("\n"); 
		query.append(",TB.teus" ).append("\n"); 
		query.append(",TB.WHF_AMT" ).append("\n"); 
		query.append(",TB.FULL_MTY_CD" ).append("\n"); 
		query.append(",TB.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("ORDER BY TB.SEQ" ).append("\n"); 

	}
}