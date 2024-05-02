/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchBbBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchBbBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBbBkgNo
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchBbBkgNoRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchBbBkgNoRSQL").append("\n"); 
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
		query.append("DISTINCT C.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD V, BKG_BOOKING B, BKG_BB_CGO C, VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(@[vvd],1,4)  --vvd" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)  --vvd" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)  --vvd" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(@[yd_cd],1,5) -- yard" ).append("\n"); 
		query.append("AND V.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("--AND C.SPCL_CGO_APRO_CD = 'Y'" ).append("\n"); 
		query.append("AND S.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5) -- yard" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_VVD V, BKG_BOOKING B, VSK_VSL_PORT_SKD S--, BKG_BB_CGO C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(@[vvd],1,4)  --vvd" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)  --vvd" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)  --vvd" ).append("\n"); 
		query.append("AND DECODE(@[io_bnd_cd],'I',V.POD_CD,V.POL_CD) = SUBSTR(@[yd_cd],1,5) -- yard" ).append("\n"); 
		query.append("AND V.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("--AND C.SPCL_CGO_APRO_CD = 'Y'" ).append("\n"); 
		query.append("AND B.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("AND S.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5) -- yard" ).append("\n"); 

	}
}