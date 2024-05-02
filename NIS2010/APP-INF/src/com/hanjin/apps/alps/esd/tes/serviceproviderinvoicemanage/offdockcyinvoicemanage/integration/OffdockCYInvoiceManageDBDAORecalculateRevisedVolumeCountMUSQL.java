/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountMUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountMUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RecalculateRevisedVolumeCountM
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountMUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountMUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_DTL D" ).append("\n"); 
		query.append("SET D.RVIS_VOL_QTY = (SELECT SUM(DECODE(RVIS_IND_FLG,'Y',0,1))" ).append("\n"); 
		query.append("                     FROM TES_TML_SO_RVIS_LIST" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                     AND TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                     AND TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("                     AND TML_SO_DTL_SEQ = @[tml_so_dtl_seq])," ).append("\n"); 
		query.append("    D.CALC_VOL_QTY = (SELECT SUM(DECODE(RVIS_IND_FLG,'Y',0,1))" ).append("\n"); 
		query.append("                     FROM TES_TML_SO_RVIS_LIST" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                     AND TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                     AND TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("                     AND TML_SO_DTL_SEQ = @[tml_so_dtl_seq])," ).append("\n"); 
		query.append("   D.INV_AMT = ( D.CTRT_RT *  (SELECT SUM(DECODE(RVIS_IND_FLG,'Y',0,1))" ).append("\n"); 
		query.append("                     FROM TES_TML_SO_RVIS_LIST" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                     AND TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                     AND TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("                     AND TML_SO_DTL_SEQ = @[tml_so_dtl_seq]))," ).append("\n"); 
		query.append("	D.PLG_TERM_DYS = (SELECT SUM(NVL(PLG_TERM_DYS,0))" ).append("\n"); 
		query.append("                     FROM TES_TML_SO_RVIS_LIST" ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("                     AND TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                     AND TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("                     AND TML_SO_DTL_SEQ = @[tml_so_dtl_seq])" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 

	}
}