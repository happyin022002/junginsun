/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceBreakBulkCostDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.26 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceBreakBulkCostDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveTerminalInvoiceBreakBulkCost
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceBreakBulkCostDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceBreakBulkCostDSQL").append("\n"); 
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
		query.append("DELETE FROM TES_TML_SO_BB_DTL B" ).append("\n"); 
		query.append("WHERE B.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND B.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND B.TML_SO_DTL_SEQ IN (SELECT D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND D.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.TML_SO_SEQ = B.TML_SO_SEQ" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ = B.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND DECODE(NVL(@[tml_so_dtl_seq],''),'','Y',NULL,'Y',D.TML_SO_DTL_SEQ) = DECODE(NVL(@[tml_so_dtl_seq],''),'','Y',NULL,'Y',@[tml_so_dtl_seq])" ).append("\n"); 
		query.append("#if (${edi_flg} == 'Y')" ).append("\n"); 
		query.append("AND D.CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}