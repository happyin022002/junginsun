/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchCmDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchCmDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CM Desc 정보 조회
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchCmDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchCmDescRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1,70),' '),CHR(13)||CHR(10),' '),'Y') CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,71,140),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,141,210),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,211,280),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,281,350),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,1,350) IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,351,420),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,421,490),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,491,560),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,561,630),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,631,700),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,351,700) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,701,770),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,771,840),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,841,920),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,921,980),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,981,1050),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,701,1050) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1051,1120),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1121,1190),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1191,1260),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1261,1330),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1331,1400),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,1051,1400) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1401,1470),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1471,1540),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1541,1610),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1611,1680),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1681,1750),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,1401,1750) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1751,1820),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1821,1890),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1891,1960),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,1961,2030),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2031,2100),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,1751,2100) IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2101,2170),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2171,2240),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2241,2310),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2311,2380),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2381,2450),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,2101,2450) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2451,2520),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2521,2590),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2591,2660),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2661,2730),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2731,2800),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,2451,2800) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2801,2870),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2871,2940),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,2941,3010),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3011,3080),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3081,3150),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,2801,3150) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3151,3220),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3221,3290),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3291,3360),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3361,3430),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3431,3500),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,3151,3500) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3501,3570),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3571,3640),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3641,3710),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3711,3780),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3781,3850),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,3501,3850) IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3851,3920),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC1" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3921,3990),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC2" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,3991,4060),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC3" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,4061,4130),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC4" ).append("\n"); 
		query.append(",BKG_SPCLCHAR_CONV_FNC(REPLACE(NVL(SUBSTR(CNTR_MF_MK_DESC,4131,4200),' '),CHR(13)||CHR(10),' '),'Y')  CM_DESC5" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("  AND   CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cm_seq} != '') " ).append("\n"); 
		query.append("  AND   CNTR_MF_SEQ  = @[cm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SUBSTR(CNTR_MF_MK_DESC,3851,4000) IS NOT NULL" ).append("\n"); 

	}
}