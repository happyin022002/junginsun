/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendCntrCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.09 김민정
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

public class UsWharfageDecMgtDBDAOsearchUsWhfSendCntrCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendCntrCnt
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendCntrCntRSQL(){
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
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendCntrCntRSQL").append("\n"); 
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
		query.append("SELECT '1' AS SEQ" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FF', RAT_AS_QTY, 0)) AS CNT_20F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FM', RAT_AS_QTY, 0)) AS CNT_20E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FF', RAT_AS_QTY, 0)) AS CNT_40F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FM', RAT_AS_QTY, 0)) AS CNT_40E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FF', RAT_AS_QTY, 0)) AS CNT_45F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FM', RAT_AS_QTY, 0)) AS CNT_45E" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if (${type_rail} != '')" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'L'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD IN ('L', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' AS SEQ" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FF', RAT_AS_QTY, 0)) AS CNT_20F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FM', RAT_AS_QTY, 0)) AS CNT_20E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FF', RAT_AS_QTY, 0)) AS CNT_40F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FM', RAT_AS_QTY, 0)) AS CNT_40E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FF', RAT_AS_QTY, 0)) AS CNT_45F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FM', RAT_AS_QTY, 0)) AS CNT_45E" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#if (${type_rail} != '')" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'R'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' AS SEQ" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FF', RAT_AS_QTY, 0)) AS CNT_20F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FM', RAT_AS_QTY, 0)) AS CNT_20E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FF', RAT_AS_QTY, 0)) AS CNT_40F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FM', RAT_AS_QTY, 0)) AS CNT_40E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FF', RAT_AS_QTY, 0)) AS CNT_45F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FM', RAT_AS_QTY, 0)) AS CNT_45E" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = 'T'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '4' AS SEQ" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FF', RAT_AS_QTY, 0)) AS CNT_20F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '20FM', RAT_AS_QTY, 0)) AS CNT_20E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FF', RAT_AS_QTY, 0)) AS CNT_40F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '40FM', RAT_AS_QTY, 0)) AS CNT_40E" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FF', RAT_AS_QTY, 0)) AS CNT_45F" ).append("\n"); 
		query.append(",SUM(DECODE(USA_WHF_RAT_UT_CD||FULL_MTY_CD, '45FM', RAT_AS_QTY, 0)) AS CNT_45E" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '5' AS SEQ" ).append("\n"); 
		query.append(",SUM(DECODE(FULL_MTY_CD, 'F', RAT_AS_QTY, 0)) AS CNT_20F" ).append("\n"); 
		query.append(",SUM(DECODE(FULL_MTY_CD, 'M', RAT_AS_QTY, 0)) AS CNT_20E" ).append("\n"); 
		query.append(",0 AS CNT_40F" ).append("\n"); 
		query.append(",0 AS CNT_40E" ).append("\n"); 
		query.append(",0 AS CNT_45F" ).append("\n"); 
		query.append(",0 AS CNT_45E" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_SND_QTY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND PORT_CD = @[port]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bound]" ).append("\n"); 

	}
}