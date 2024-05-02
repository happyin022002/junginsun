/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchJapCstmsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.11.17 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchJapCstmsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일본세관 신고를 위한 B/L INFO를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchJapCstmsInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchJapCstmsInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(DREF.CY_OP_CD,BJBL.CY_OPR_ID)             AS CY_OP_CD" ).append("\n"); 
		query.append(", NVL(DREF.INFO_CGO_FLG, 'N')                   AS INFO_CGO_FLG" ).append("\n"); 
		query.append(", DECODE(BJBL.FULL_MTY_CD ,'F','FULL','EMPTY' ) AS FULL_MTY_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append(", BKG_DO_REF  DREF" ).append("\n"); 
		query.append(", BKG_CSTMS_JP_BL BJBL" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKGM.BKG_NO = DREF.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKGM.BL_NO  = BJBL.BL_NO(+)" ).append("\n"); 

	}
}