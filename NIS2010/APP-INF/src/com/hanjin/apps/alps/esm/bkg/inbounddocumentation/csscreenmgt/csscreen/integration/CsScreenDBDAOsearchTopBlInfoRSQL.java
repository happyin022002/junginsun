/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenDBDAOsearchTopBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 윤윤한
*@LastVersion : 1.0
* 2009.12.23 윤윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YYN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchTopBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C/S Screen Top부분의 공통적인 영역을 담당한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchTopBlInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchTopBlInfoRSQL").append("\n"); 
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
		query.append("SELECT BKGM.BKG_NO                                       AS BKG_NO" ).append("\n"); 
		query.append(",BKGM.BL_NO                                        AS BL_NO" ).append("\n"); 
		query.append(",DECODE(ISS.OBL_SRND_FLG,'Y','S', BKGM.BL_TP_CD)   AS BL_TP_CD" ).append("\n"); 
		query.append(",DECODE(BKGM.BKG_CRE_TP_CD,'S','Y',DECODE( NVL(BKGM.FM_BKG_NO,'N'),'N','N','Y')) AS SPLIT_FLG" ).append("\n"); 
		query.append("FROM BKG_BOOKING  BKGM" ).append("\n"); 
		query.append(",BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND ISS.BKG_NO(+) = BKGM.BKG_NO" ).append("\n"); 

	}
}