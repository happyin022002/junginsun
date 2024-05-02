/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.29 
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

public class CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCtRSQL").append("\n"); 
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
		query.append("SELECT 'CT' AS EDI_MSG_ID, C.EDI_RCV_ID, C.EDI_SND_ID, C.YD_CD" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("       BKG_BOOKING  B," ).append("\n"); 
		query.append("       BKG_EDI_YD   C" ).append("\n"); 
		query.append(" WHERE A.BL_NO  = @[bl_no] " ).append("\n"); 
		query.append("   AND A.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("   AND C.PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND C.PORT_CD IN (" ).append("\n"); 
		query.append("					SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("					WHERE CNT_cD='US'" ).append("\n"); 
		query.append("					AND CSTMS_DIV_ID='US_CR_CT_PORT_STUP'" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("   AND B.SLAN_CD IN (C.SLAN_CD1,C.SLAN_CD2,C.SLAN_CD3,C.SLAN_CD4,C.SLAN_CD5," ).append("\n"); 
		query.append("                     C.SLAN_CD6,C.SLAN_CD7,C.SLAN_CD8,C.SLAN_CD9,C.SLAN_CD10)" ).append("\n"); 
		query.append("   AND (C.FULL_RLSE_EDI_CD = '1' OR C.FULL_RLSE_EDI_CD = '2')" ).append("\n"); 
		query.append("   AND ROWNUM	= 1" ).append("\n"); 
		query.append("   AND 'CT1'    = @[edi_knd]" ).append("\n"); 
		query.append("   AND NVL(A.MRN_TML_EDI_SND_CD,' ') <> 'T'" ).append("\n"); 
		query.append("   AND C.EDI_RCV_ID IN (" ).append("\n"); 
		query.append("						SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("						WHERE CNT_cD='US'" ).append("\n"); 
		query.append("						AND CSTMS_DIV_ID='US_CR_CT_TML_STUP'" ).append("\n"); 
		query.append("						)" ).append("\n"); 

	}
}