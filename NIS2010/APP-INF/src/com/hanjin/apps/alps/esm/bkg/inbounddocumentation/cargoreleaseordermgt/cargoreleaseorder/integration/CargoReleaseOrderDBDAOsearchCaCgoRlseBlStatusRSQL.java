/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoRlseBlStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.23
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.07.23 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoRlseBlStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoRlseBlStatusRSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoRlseBlStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoRlseBlStatusRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("       A.BL_NO," ).append("\n"); 
		query.append("       DECODE(B.OBL_SRND_FLG,'Y','S', NVL(A.BL_TP_CD,'B')) AS BL_STATUS," ).append("\n"); 
		query.append("       B.BL_CPY_KNT," ).append("\n"); 
		query.append("       NVL(B.OBL_RLSE_FLG,'N')   AS BL_RLSE," ).append("\n"); 
		query.append("       B.OBL_ISS_OFC_CD          AS BL_RLSE_OFC_CD, " ).append("\n"); 
		query.append("       B.OBL_ISS_USR_ID          AS BL_RLSE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(B.OBL_ISS_DT,'YYYY-MM-DD HH24:MI') AS BL_RLSE_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       B.OBL_RDEM_KNT            AS OBL_RDEM_KNT," ).append("\n"); 
		query.append("       B.OBL_RDEM_OFC_CD         AS OBL_RDEM_OFC_CD," ).append("\n"); 
		query.append("       B.OBL_RDEM_USR_ID         AS OBL_RDEM_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(B.OBL_RDEM_DT,'YYYY-MM-DD HH24:MI') AS OBL_RDEM_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       G.BL_RCV_KNT              AS BL_IBD," ).append("\n"); 
		query.append("       G.BL_RCV_OFC_CD           AS BL_IBD_OFC_CD," ).append("\n"); 
		query.append("       G.BL_RCV_USR_ID           AS BL_IBD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(G.BL_RCV_DT,'YYYY-MM-DD HH24:MI') AS BL_IBD_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       B.BL_OTR_DOC_RCV_CD       AS BL_OTR_DOC_RCV_CD," ).append("\n"); 
		query.append("       B.OTR_DOC_RCV_OFC_CD      AS OTR_DOC_RCV_OFC_CD," ).append("\n"); 
		query.append("       B.OTR_DOC_RCV_USR_ID      AS OTR_DOC_RCV_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(B.OTR_DOC_RCV_DT,'YYYY-MM-DD HH24:MI') AS OTR_DOC_RCV_DT," ).append("\n"); 
		query.append("       E.CNT_CD," ).append("\n"); 
		query.append("       SUBSTR(DECODE(SUBSTR(A.DEL_CD,1,2),'CA',A.DEL_CD," ).append("\n"); 
		query.append("              DECODE(SUBSTR(F.DEL_CD,1,2),'CA',F.DEL_CD,F.CSTMS_PORT_CD)),1,2) DEL_CD," ).append("\n"); 
		query.append("       B.OBL_ISS_RMK " ).append("\n"); 
		query.append("  FROM BKG_BOOKING   A," ).append("\n"); 
		query.append("       BKG_BL_ISS    B," ).append("\n"); 
		query.append("       COM_USER            E," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL    F," ).append("\n"); 
		query.append("       BKG_CGO_RLSE        G" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   AND A.BL_NO  = F.BL_NO(+)" ).append("\n"); 
		query.append("   AND F.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("   AND A.BL_NO  = G.BL_NO(+)" ).append("\n"); 

	}
}