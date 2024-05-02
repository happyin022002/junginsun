/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.14 김민정
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

public class UsWharfageDecMgtDBDAOsearchUsWhfBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfBlList
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfBlListRSQL(){
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
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfBlListRSQL").append("\n"); 
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
		query.append("SELECT  TB.*" ).append("\n"); 
		query.append(",DECODE(BC.CNTR_VOL_QTY, 1, 'D', 'P') AS PARTIAL" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT  B.BL_NO" ).append("\n"); 
		query.append(",B.IO_BND_CD" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.FULL_MTY_CD" ).append("\n"); 
		query.append(",B.CSTMS_DESC" ).append("\n"); 
		query.append(",C.USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",B.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("#if (${type_rail} != '')" ).append("\n"); 
		query.append(",C.USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(C.USA_WHF_TRSP_TP_CD, 'R', 'L', C.USA_WHF_TRSP_TP_CD) AS USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",DECODE(@[bound], 'I', C.DE_TERM_CD, C.RCV_TERM_CD) AS TERM" ).append("\n"); 
		query.append(",DECODE(C.USA_WHF_RAT_UT_CD, '20F', C.CNTR_VOL_QTY) FT20" ).append("\n"); 
		query.append(",DECODE(C.USA_WHF_RAT_UT_CD, '40F', C.CNTR_VOL_QTY) FT40" ).append("\n"); 
		query.append(",DECODE(C.USA_WHF_RAT_UT_CD, '45F', C.CNTR_VOL_QTY) FT45" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.SKD_VOY_NO" ).append("\n"); 
		query.append(",B.SKD_DIR_CD" ).append("\n"); 
		query.append(",B.PORT_CD" ).append("\n"); 
		query.append(",C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",C.USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",C.RAT_AS_QTY" ).append("\n"); 
		query.append(",C.WHF_UT_PRC" ).append("\n"); 
		query.append(",C.CRE_USR_ID" ).append("\n"); 
		query.append(",M.STE_CD" ).append("\n"); 
		query.append(",MC.CRR_CD" ).append("\n"); 
		query.append(",BKG.BKG_NO" ).append("\n"); 
		query.append("FROM  BKG_USA_WHF_BL B" ).append("\n"); 
		query.append(",BKG_USA_WHF_CNTR C" ).append("\n"); 
		query.append(",MDM_LOCATION M" ).append("\n"); 
		query.append(",MDM_VSL_CNTR MC" ).append("\n"); 
		query.append(",BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE  B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND  B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND  B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND  B.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("AND  B.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("AND  B.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("AND  B.ORG_DEST_LOC_CD = M.LOC_CD(+)" ).append("\n"); 
		query.append("AND  B.VSL_CD = MC.VSL_CD(+)" ).append("\n"); 
		query.append("AND  B.BL_NO = BKG.BL_NO(+)" ).append("\n"); 
		query.append("AND  B.VSL_CD = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("AND  B.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND  B.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("AND  B.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("AND  B.PORT_CD = @[port]" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append(",BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE TB.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND TB.CNTR_NO = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY TB.BL_NO, TB.CNTR_NO" ).append("\n"); 

	}
}