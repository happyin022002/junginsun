/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceContainerListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.01 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceContainerListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveTerminalInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceContainerListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAORemoveTerminalInvoiceContainerListDSQL").append("\n"); 
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
		query.append("DELETE FROM  TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("WHERE 	TML_SO_OFC_CTY_CD 			    = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    TML_SO_SEQ                		= @[tml_so_seq]" ).append("\n"); 
		query.append("AND    VSL_CD                			= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO                		= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD                		= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    UPPER(IO_BND_CD)          		= @[io_bnd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 2008-07-30: 이D의 요청으로 Reverify일 경우는 Discrepancy만 지운다" ).append("\n"); 
		query.append("#if (${reverify_yn} == 'Y')" ).append("\n"); 
		query.append("AND    VRFY_RSLT_IND_CD = 'DC'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}