/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOaddOblRcvByUsCgoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.05.11 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOaddOblRcvByUsCgoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public BLIssuanceDBDAOaddOblRcvByUsCgoCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_otr_doc_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOaddOblRcvByUsCgoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_BL_ISS (" ).append("\n"); 
		query.append("            BKG_NO              ," ).append("\n"); 
		query.append("            OBL_PRN_FLG         ," ).append("\n"); 
		query.append("            BL_RDY_FLG          ," ).append("\n"); 
		query.append("            BL_PRF_SHPR_FLG     ," ).append("\n"); 
		query.append("            OBL_ISS_FLG         ," ).append("\n"); 
		query.append("            OBL_INET_FLG        ," ).append("\n"); 
		query.append("            BL_OTR_DOC_RCV_CD   ," ).append("\n"); 
		query.append("            OTR_DOC_RCV_OFC_CD  ," ).append("\n"); 
		query.append("            OTR_DOC_RCV_USR_ID  ," ).append("\n"); 
		query.append("            OTR_DOC_RCV_DT      ," ).append("\n"); 
		query.append("            CRE_USR_ID          ," ).append("\n"); 
		query.append("            CRE_DT              ," ).append("\n"); 
		query.append("            UPD_USR_ID          ," ).append("\n"); 
		query.append("            UPD_DT )" ).append("\n"); 
		query.append("VALUES     (@[bkg_no]," ).append("\n"); 
		query.append("            'N'," ).append("\n"); 
		query.append("            'N'," ).append("\n"); 
		query.append("            'N'," ).append("\n"); 
		query.append("            'N'," ).append("\n"); 
		query.append("            'N'," ).append("\n"); 
		query.append("            @[bl_otr_doc_rcv_cd]," ).append("\n"); 
		query.append("            @[ofc_cd]," ).append("\n"); 
		query.append("            @[usr_id]," ).append("\n"); 
		query.append("            GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[ofc_cd])) ," ).append("\n"); 
		query.append("            @[usr_id]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[usr_id]," ).append("\n"); 
		query.append("            SYSDATE )" ).append("\n"); 

	}
}