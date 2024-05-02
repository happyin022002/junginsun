/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
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

public class CargoReleaseOrderDBDAOsearchEdiRcvSndIdCrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiRcvSndIdCrRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdCrRSQL").append("\n"); 
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
		query.append("SELECT 'CR' AS EDI_MSG_ID, E.EDI_RCV_ID, E.EDI_SND_ID, E.YD_CD" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_VVD          C," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD D," ).append("\n"); 
		query.append("       BKG_EDI_YD       E" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO      = C.BKG_NO" ).append("\n"); 
		query.append("   AND C.VSL_CD      = D.VSL_CD" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO  = D.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD  = D.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND D.VPS_PORT_CD LIKE 'US%'  " ).append("\n"); 
		query.append("   AND C.SLAN_CD     = D.SLAN_CD" ).append("\n"); 
		query.append("   AND D.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(E.YD_CD,6) = NVL( @[bkg_pod_yd_cd] , SUBSTR(E.YD_CD,6) )" ).append("\n"); 
		query.append("   AND D.YD_CD       = E.YD_CD" ).append("\n"); 
		query.append("   AND (E.FULL_RLSE_EDI_CD = '1' OR E.FULL_RLSE_EDI_CD = '2')" ).append("\n"); 
		query.append("   AND ROWNUM	= 1" ).append("\n"); 
		query.append("   AND 'CR1'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION   " ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, E.EDI_RCV_ID, E.EDI_SND_ID, E.YD_CD" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_VVD          C," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD D," ).append("\n"); 
		query.append("       BKG_EDI_YD       E" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.FRT_CLT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO      = C.BKG_NO" ).append("\n"); 
		query.append("   AND C.VSL_CD      = D.VSL_CD" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO  = D.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD  = D.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND D.VPS_PORT_CD LIKE 'US%'  " ).append("\n"); 
		query.append("   AND C.SLAN_CD     = D.SLAN_CD" ).append("\n"); 
		query.append("   AND D.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(E.YD_CD,6) = NVL( @[bkg_pod_yd_cd] , SUBSTR(E.YD_CD,6) )" ).append("\n"); 
		query.append("   AND D.YD_CD       = E.YD_CD" ).append("\n"); 
		query.append("   AND E.FULL_RLSE_EDI_CD = DECODE(SUBSTR(B.POD_CD,1,2),'CA','2','1')" ).append("\n"); 
		query.append("   AND ROWNUM	      = 1" ).append("\n"); 
		query.append("   AND 'CR2'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, C.EDI_RCV_ID, C.EDI_SND_ID, C.YD_CD " ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("       BKG_BOOKING  B," ).append("\n"); 
		query.append("       BKG_EDI_YD   C" ).append("\n"); 
		query.append(" WHERE A.BL_NO        = @[bl_no] " ).append("\n"); 
		query.append("   AND A.BL_NO        = B.BL_NO" ).append("\n"); 
		query.append("   AND A.FRT_CLT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND DECODE(A.CSTMS_CLR_CD,'Y','Y'," ).append("\n"); 
		query.append("                             'T','Y'," ).append("\n"); 
		query.append("                             'E','Y'," ).append("\n"); 
		query.append("                             'I','Y'," ).append("\n"); 
		query.append("                             'W','Y'," ).append("\n"); 
		query.append("                             'P','Y','N') = 'Y'" ).append("\n"); 
		query.append("   AND C.PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(C.YD_CD,6) = NVL( @[bkg_pod_yd_cd] , SUBSTR(C.YD_CD,6) )" ).append("\n"); 
		query.append("   AND B.SLAN_CD IN (C.SLAN_CD1,C.SLAN_CD2,C.SLAN_CD3,C.SLAN_CD4,C.SLAN_CD5," ).append("\n"); 
		query.append("                     C.SLAN_CD6,C.SLAN_CD7,C.SLAN_CD8,C.SLAN_CD9,C.SLAN_CD10)" ).append("\n"); 
		query.append("   AND C.FULL_RLSE_EDI_CD = '2'" ).append("\n"); 
		query.append("   AND ROWNUM	      = 1" ).append("\n"); 
		query.append("   AND 'CR3'    = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'CR' AS EDI_MSG_ID, E.EDI_RCV_ID, E.EDI_SND_ID, E.YD_CD" ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_VVD          C," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD D," ).append("\n"); 
		query.append("       BKG_EDI_YD       E" ).append("\n"); 
		query.append(" WHERE A.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_NO       = B.BL_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO      = C.BKG_NO" ).append("\n"); 
		query.append("   AND C.VSL_CD      = D.VSL_CD" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO  = D.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD  = D.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND D.VPS_PORT_CD LIKE 'US%'  " ).append("\n"); 
		query.append("   AND C.SLAN_CD     = D.SLAN_CD" ).append("\n"); 
		query.append("   AND D.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(E.YD_CD,6) = NVL( @[bkg_pod_yd_cd] , SUBSTR(E.YD_CD,6) )" ).append("\n"); 
		query.append("   AND D.YD_CD       = E.YD_CD" ).append("\n"); 
		query.append("   AND ROWNUM	          = 1" ).append("\n"); 
		query.append("   AND 'CR4'              = @[edi_knd]" ).append("\n"); 

	}
}