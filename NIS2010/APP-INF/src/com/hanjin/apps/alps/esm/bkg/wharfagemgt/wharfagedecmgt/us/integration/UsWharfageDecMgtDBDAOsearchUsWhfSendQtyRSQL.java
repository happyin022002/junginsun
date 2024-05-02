/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.22 김민정
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

public class UsWharfageDecMgtDBDAOsearchUsWhfSendQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendQty
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendQtyRSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendQtyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${type_rail} != '')" ).append("\n"); 
		query.append("TB.*" ).append("\n"); 
		query.append(",'' AS FT20" ).append("\n"); 
		query.append(",'' AS FT40" ).append("\n"); 
		query.append(",'' AS FT45" ).append("\n"); 
		query.append(",'' AS CONT" ).append("\n"); 
		query.append(",'' AS TEUS" ).append("\n"); 
		query.append(",'' AS WHF_AMT" ).append("\n"); 
		query.append(",'' AS FULL_MTY_CD" ).append("\n"); 
		query.append(",'' AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",'' AS UT_PRC_20FT" ).append("\n"); 
		query.append(",'' AS UT_PRC_40FT" ).append("\n"); 
		query.append(",'' AS UT_PRC_45FT" ).append("\n"); 
		query.append(",'' AS UT_PRC_CONT" ).append("\n"); 
		query.append(",'' AS UT_PRC_TEUS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("TB.SEQ" ).append("\n"); 
		query.append(",TB.LOCAL_COUNT + TB.RAIL_COUNT AS LOCAL_COUNT" ).append("\n"); 
		query.append(",TB.LOCAL_RATE" ).append("\n"); 
		query.append(",TB.LOCAL_AMT + (TB.RAIL_COUNT * TB.LOCAL_RATE) AS LOCAL_AMT" ).append("\n"); 
		query.append(",0 AS RAIL_COUNT" ).append("\n"); 
		query.append(",TB.RAIL_RATE" ).append("\n"); 
		query.append(",0 AS RAIL_AMT" ).append("\n"); 
		query.append(",TB.TS_COUNT" ).append("\n"); 
		query.append(",TB.TS_RATE" ).append("\n"); 
		query.append(",TB.TS_AMT" ).append("\n"); 
		query.append(",'' AS FT20" ).append("\n"); 
		query.append(",'' AS FT40" ).append("\n"); 
		query.append(",'' AS FT45" ).append("\n"); 
		query.append(",'' AS CONT" ).append("\n"); 
		query.append(",'' AS TEUS" ).append("\n"); 
		query.append(",'' AS WHF_AMT" ).append("\n"); 
		query.append(",'' AS FULL_MTY_CD" ).append("\n"); 
		query.append(",'' AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",'' AS UT_PRC_20FT" ).append("\n"); 
		query.append(",'' AS UT_PRC_40FT" ).append("\n"); 
		query.append(",'' AS UT_PRC_45FT" ).append("\n"); 
		query.append(",'' AS UT_PRC_CONT" ).append("\n"); 
		query.append(",'' AS UT_PRC_TEUS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '1' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '20F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '40F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '45F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '4' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '20F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '5' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '40F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '6' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '45F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '7' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '20F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '8' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '40F'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '9' AS SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', RAT_AS_QTY, 0)) AS LOCAL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_UT_PRC, 0)) AS LOCAL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'L', WHF_AMT, 0))    AS LOCAL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', RAT_AS_QTY, 0)) AS RAIL_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_UT_PRC, 0)) AS RAIL_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'R', WHF_AMT, 0))    AS RAIL_AMT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', RAT_AS_QTY, 0)) AS TS_COUNT" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_UT_PRC, 0)) AS TS_RATE" ).append("\n"); 
		query.append(",MAX(DECODE(USA_WHF_TRSP_TP_CD, 'T', WHF_AMT, 0))    AS TS_AMT" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = 'M'" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = '45F'" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append("ORDER BY TB.SEQ" ).append("\n"); 

	}
}