/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseViewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchUsCgoRlseViewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CGO_RLSE 단건 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchUsCgoRlseViewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseViewRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO" ).append("\n"); 
		query.append(", NVL(BK.POD_CD,'') BKG_POD_CD" ).append("\n"); 
		query.append(", SUBSTR(BK.POD_NOD_CD, 6, 2) BKG_POD_YD_CD" ).append("\n"); 
		query.append("FROM BKG_CGO_RLSE A, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND NVL(OBL_RDEM_FLG,'N') ='Y' " ).append("\n"); 
		query.append("AND NVL(FRT_CLT_FLG,'N') ='Y'" ).append("\n"); 
		query.append("AND MRN_TML_EDI_LST_MSG_ID = 'CR'" ).append("\n"); 
		query.append("AND A.BL_NO = BK.BL_NO" ).append("\n"); 

	}
}