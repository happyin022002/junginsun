/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaFocFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaFocFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaFocFlg
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaFocFlgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaFocFlgRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("MAX(B.FRT_CLT_FLG)  AS OLD_FRT_CLT_FLG,     /* OLD F */" ).append("\n"); 
		query.append("MAX(B.OBL_RDEM_FLG) AS OLD_OBL_RDEM_FLG,    /* OLD O */" ).append("\n"); 
		query.append("MAX(B.CSTMS_CLR_CD) AS OLD_CSTMS_CLR_CD,    /* OLD C */" ).append("\n"); 
		query.append("MAX(A.FRT_CLT_FLG)  AS NEW_FRT_CLT_FLG,     /* NEW F */" ).append("\n"); 
		query.append("MAX(A.OBL_RDEM_FLG) AS NEW_OBL_RDEM_FLG,    /* NEW O */" ).append("\n"); 
		query.append("DECODE(MAX(C.BL_NO),NULL,'X','','X',MAX(A.CSTMS_CLR_CD)) AS NEW_CSTMS_CLR_CD     /* NEW C */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_HIS B," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL C" ).append("\n"); 
		query.append("WHERE A.BL_NO = @[bl_no]     " ).append("\n"); 
		query.append("   AND A.BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("   AND B.HIS_SEQ = ( SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                      FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("--                       AND NVL(DO_HLD_FLG ,'N')= 'N'" ).append("\n"); 
		query.append("                       AND HIS_SEQ < (SELECT DECODE( MAX(HIS_SEQ)-1, 0, 2, MAX(HIS_SEQ) ) FROM BKG_CGO_RLSE_HIS " ).append("\n"); 
		query.append("                                      WHERE BL_NO = @[bl_no] " ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                             ) " ).append("\n"); 
		query.append("   AND A.BL_NO  = C.BL_NO(+)" ).append("\n"); 
		query.append("   AND 'CA' = C.CNT_CD(+)" ).append("\n"); 

	}
}