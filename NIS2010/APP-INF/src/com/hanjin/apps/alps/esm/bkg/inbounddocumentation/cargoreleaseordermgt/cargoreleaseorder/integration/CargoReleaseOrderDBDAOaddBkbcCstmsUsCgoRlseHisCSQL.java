/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.14 
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

public class CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ds_po_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_evnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgor_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddBkbcCstmsUsCgoRlseHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CGO_RLSE_HIS (" ).append("\n"); 
		query.append("            BL_NO              ," ).append("\n"); 
		query.append("            HIS_SEQ            ," ).append("\n"); 
		query.append("            FRT_CLT_FLG        ," ).append("\n"); 
		query.append("            OBL_RDEM_FLG       ," ).append("\n"); 
		query.append("            CSTMS_CLR_CD       ," ).append("\n"); 
		query.append("            CSTMS_DSPO_CD      ," ).append("\n"); 
		query.append("            CUST_EDI_SND_CD    ," ).append("\n"); 
		query.append("            MRN_TML_EDI_SND_CD ," ).append("\n"); 
		query.append("            INLND_YD_EDI_SND_CD," ).append("\n"); 
		query.append("            EVNT_OFC_CD        ," ).append("\n"); 
		query.append("            CGOR_EVNT_TP_CD    ," ).append("\n"); 
		query.append("            EVNT_USR_ID        ," ).append("\n"); 
		query.append("            EVNT_DT            ," ).append("\n"); 
		query.append("            CGOR_TEAM_CD       ," ).append("\n"); 
		query.append("            CGOR_EVNT_NM       ," ).append("\n"); 
		query.append("            EVNT_GDT           ," ).append("\n"); 
		query.append("            CRE_USR_ID         ," ).append("\n"); 
		query.append("            CRE_DT             ," ).append("\n"); 
		query.append("            UPD_USR_ID         ," ).append("\n"); 
		query.append("            UPD_DT             ," ).append("\n"); 
		query.append("            CSTMS_LOC_CD	   ," ).append("\n"); 
		query.append("			DO_HLD_FLG)" ).append("\n"); 
		query.append("    (SELECT @[bl_no],  /* 변수 치환 blNo */" ).append("\n"); 
		query.append("            NVL(MAX(HIS_SEQ),0) + 1, " ).append("\n"); 
		query.append("            NVL(MAX(FRT_CLT_FLG),'N')," ).append("\n"); 
		query.append("            NVL(MAX(OBL_RDEM_FLG),'N')," ).append("\n"); 
		query.append("            @[cstms_clr_cd],   " ).append("\n"); 
		query.append("            @[cstms_ds_po_cd], " ).append("\n"); 
		query.append("            NULL," ).append("\n"); 
		query.append("            NULL," ).append("\n"); 
		query.append("            NULL," ).append("\n"); 
		query.append("            @[evnt_ofc_cd], " ).append("\n"); 
		query.append("            'C'  ," ).append("\n"); 
		query.append("            @[evnt_usr_id], " ).append("\n"); 
		query.append("            NVL(MAX((SELECT CSTMS_CLR_LST_DT FROM BKG_CGO_RLSE WHERE BL_NO = @[bl_no]))," ).append("\n"); 
		query.append("                GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,'USNYC'))," ).append("\n"); 
		query.append("            @[cgor_team_cd],  " ).append("\n"); 
		query.append("            @[cgo_evnt_nm], " ).append("\n"); 
		query.append("            NVL(" ).append("\n"); 
		query.append("        	    GLOBALDATE_PKG.TIME_CONV_FNC('USNYC'," ).append("\n"); 
		query.append("                  MAX((SELECT CSTMS_CLR_LST_DT FROM BKG_CGO_RLSE WHERE BL_NO = @[bl_no])),'GMT')," ).append("\n"); 
		query.append("                GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,'GMT')), " ).append("\n"); 
		query.append("            @[evnt_usr_id], " ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[evnt_usr_id], " ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[cstms_loc_cd]," ).append("\n"); 
		query.append("			NVL(MAX((" ).append("\n"); 
		query.append("				SELECT NVL(A.DO_HLD_FLG,'N') DO_HLD_FLG" ).append("\n"); 
		query.append("			 	FROM BKG_DO_REF A," ).append("\n"); 
		query.append("					 BKG_BOOKING B" ).append("\n"); 
		query.append("			 	WHERE A.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("			   	AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("			)),'N') DO_HLD_FLG" ).append("\n"); 
		query.append("       FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("      WHERE BL_NO = @[bl_no] " ).append("\n"); 
		query.append("        AND HIS_SEQ = (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                         FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                        WHERE BL_NO = @[bl_no]))" ).append("\n"); 

	}
}