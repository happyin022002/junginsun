/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAOSearchTsBkgCloseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2014.02.03 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchTsBkgCloseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 vvd, pol이 T/S close되었는지 확인한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchTsBkgCloseRSQL(){
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchTsBkgCloseRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT COFF.VSL_CD || COFF.SKD_VOY_NO || COFF.SKD_DIR_CD TS_CLOSED_VVD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                , VVD.POL_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("		   AND BK.POL_CD <> VVD.POL_CD" ).append("\n"); 
		query.append("           AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND 1 < (SELECT COUNT(1) FROM BKG_VVD V WHERE VVD.BKG_NO = V.BKG_NO)" ).append("\n"); 
		query.append("        UNION " ).append("\n"); 
		query.append("        SELECT DTL.VSL_CD, DTL.SKD_VOY_NO, DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                , SUBSTR(DTL.ORG_NOD_CD,  1, 5) POL_CD,  DTL.ORG_NOD_CD  POL_YD_CD, ORG_CLPT_IND_SEQ  POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_PROD_CTL_MST MST" ).append("\n"); 
		query.append("         WHERE MST.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("		   AND MST.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("		   AND MST.POL_NOD_CD <> DTL.ORG_NOD_CD" ).append("\n"); 
		query.append("           AND DTL.TRSP_MOD_CD IN ('VD', 'WD')" ).append("\n"); 
		query.append("           AND 1 < (SELECT COUNT(1) FROM PRD_PROD_CTL_ROUT_DTL D WHERE DTL.PCTL_NO = D.PCTL_NO AND D.TRSP_MOD_CD IN ('VD', 'WD'))) VVD" ).append("\n"); 
		query.append("     , BKG_TS_COFF_TM COFF" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = COFF.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = COFF.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = COFF.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD = COFF.POL_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CLPT_IND_SEQ = COFF.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND COFF.BKG_CLZ_STS_CD = 'C'" ).append("\n"); 

	}
}