/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceN3RDListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2011.02.25 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ParkChaeHeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceN3RDListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveTerminalInvoiceN3RDList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceN3RDListDSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceN3RDListDSQL").append("\n"); 
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
		query.append("DELETE FROM TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE T.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND T.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND T.TML_SO_DTL_SEQ IN (SELECT D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("						FROM TES_TML_SO_DTL D" ).append("\n"); 
		query.append("						WHERE D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("						AND D.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("						AND D.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("						AND D.VSL_CD     = @[vsl_cd]   	" ).append("\n"); 
		query.append("	 					AND D.SKD_VOY_NO = @[skd_voy_no]	" ).append("\n"); 
		query.append("	 					AND D.SKD_DIR_CD = @[skd_dir_cd]  " ).append("\n"); 
		query.append("						AND D.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						AND D.TML_SO_SEQ = T.TML_SO_SEQ" ).append("\n"); 
		query.append("						AND D.TML_SO_DTL_SEQ = T.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("#if (${delete_mode} != '' and ${delete_mode}=='ROW') " ).append("\n"); 
		query.append("						AND D.TML_SO_DTL_SEQ = NVL(@[tml_so_dtl_seq],0)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 

	}
}