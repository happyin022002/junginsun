/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchIbdBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchIbdBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchIbdBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchIbdBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.BL_NO,@[bl_no],'I','B') as ibd_bkg_ind," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.BKG_NO,A.BKG_NO) as bkg_no," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("                                     A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) as vsk_vvd_cd, " ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.VSL_CD," ).append("\n"); 
		query.append("                                     A.VSL_CD) as VSL_CD," ).append("\n"); 
		query.append("	   DECODE(B.BL_NO,@[bl_no],B.SKD_VOY_NO," ).append("\n"); 
		query.append("                                     A.SKD_VOY_NO) as SKD_VOY_NO," ).append("\n"); 
		query.append("	   DECODE(B.BL_NO,@[bl_no],B.SKD_DIR_CD," ).append("\n"); 
		query.append("                                     A.SKD_DIR_CD) as SKD_DIR_CD,                                      " ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.CSTMS_POL_CD, NVL(A.PRE_RLY_PORT_CD, A.POL_CD)) as pol_cd," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.CSTMS_POD_CD, NVL(A.PST_RLY_PORT_CD, A.POD_CD))as pod_Cd," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.DEL_CD, A.DEL_CD) as del_cd,                         " ).append("\n"); 
		query.append("       'HJFTP' as edi_snp_snd_id," ).append("\n"); 
		query.append("       DECODE(CROX_RCV_ID,NULL,DECODE(USBAL_RCV_ID,NULL,VIS_RCV_ID,USBAL_RCV_ID),CROX_RCV_ID) as edi_snp_rcv_id,    " ).append("\n"); 
		query.append("       NVL(EDI_ADD_IND,'N') as edi_add_ind                                 " ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL B," ).append("\n"); 
		query.append("       (SELECT MAX(CROX_RCV_ID)  CROX_RCV_ID," ).append("\n"); 
		query.append("               MAX(USBAL_RCV_ID) USBAL_RCV_ID," ).append("\n"); 
		query.append("               MAX(VIS_RCV_ID)   VIS_RCV_ID," ).append("\n"); 
		query.append("               DECODE(COUNT(*),0,'N','Y') EDI_ADD_IND" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 'HMIN' CROX_RCV_ID," ).append("\n"); 
		query.append("                       ''     USBAL_RCV_ID," ).append("\n"); 
		query.append("                       ''     VIS_RCV_ID" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING  A," ).append("\n"); 
		query.append("                       BKG_BL_DOC   B," ).append("\n"); 
		query.append("                       MDM_LOCATION C," ).append("\n"); 
		query.append("                       BKG_EDI_YD   D" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO  = @[bkg_no]  " ).append("\n"); 
		query.append("                   AND A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND A.POD_CD  <> 'USNYC'" ).append("\n"); 
		query.append("                   AND A.DEL_CD  = C.LOC_CD" ).append("\n"); 
		query.append("                   AND C.SCC_CD  = 'USNYC'" ).append("\n"); 
		query.append("                   AND SUBSTR(D.YD_CD,1,2) IN ('CA','MX','US')" ).append("\n"); 
		query.append("                   AND TRIM(D.EDI_RCV_ID) LIKE TRIM(@[edi_rcv_id]) || '%'" ).append("\n"); 
		query.append("                   AND @[cstms_dspo_cd] <> '1J'" ).append("\n"); 
		query.append("                UNION ALL   " ).append("\n"); 
		query.append("                SELECT ''," ).append("\n"); 
		query.append("                       'POPBALSMT'," ).append("\n"); 
		query.append("                       ''" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING  A," ).append("\n"); 
		query.append("                       BKG_BL_DOC   B," ).append("\n"); 
		query.append("                       MDM_LOCATION C," ).append("\n"); 
		query.append("                       BKG_EDI_YD   D" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("                   AND A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND A.POD_CD IN ('USNYC','USORF')" ).append("\n"); 
		query.append("                   AND A.DEL_CD  = C.LOC_CD" ).append("\n"); 
		query.append("                   AND C.SCC_CD  = 'USBAL'" ).append("\n"); 
		query.append("                   AND SUBSTR(D.YD_CD,1,2) IN ('CA','MX','US')" ).append("\n"); 
		query.append("                   AND TRIM(D.EDI_RCV_ID) LIKE TRIM(@[edi_rcv_id]) || '%'               " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append(" WHERE A.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("   AND B.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("   AND A.BL_NO     = B.BL_NO(+)" ).append("\n"); 

	}
}