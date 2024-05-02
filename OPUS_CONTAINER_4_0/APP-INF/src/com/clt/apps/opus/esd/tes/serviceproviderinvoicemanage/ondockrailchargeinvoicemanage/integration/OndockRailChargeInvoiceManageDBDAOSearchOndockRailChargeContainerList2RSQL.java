/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.14 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOndockRailChargeContainerList2
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerList2RSQL(){
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
		params.put("vrfy_rslt_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerList2RSQL").append("\n"); 
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
		query.append("SELECT  B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD vvd         ," ).append("\n"); 
		query.append("B.DSCR_IND_CD		   ," ).append("\n"); 
		query.append("B.CNTR_NO             ," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD        ," ).append("\n"); 
		query.append("B.DCGO_CLSS_CD        ," ).append("\n"); 
		query.append("B.CNTR_STY_CD		   ," ).append("\n"); 
		query.append("TO_CHAR(B.WRK_DT,'YYYY-MM-DD') WRK_DT            ," ).append("\n"); 
		query.append("TO_CHAR(B.CLM_DT,'YYYY-MM-DD') CLM_DT            ," ).append("\n"); 
		query.append("TO_CHAR(B.RAIL_BIL_DT,'YYYY-MM-DD') RAIL_BIL_DT  ," ).append("\n"); 
		query.append("B.VRFY_RSLT_IND_CD    ," ).append("\n"); 
		query.append("B.CNTR_RMK" ).append("\n"); 
		query.append("FROM    TES_TML_SO_HDR A, TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("WHERE   A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND     A.TML_SO_SEQ = B.TML_SO_SEQ" ).append("\n"); 
		query.append("AND     B.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND     B.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND     B.VRFY_RSLT_IND_CD = @[vrfy_rslt_ind_cd]" ).append("\n"); 
		query.append("ORDER BY B.DSCR_IND_CD ASC, B.CNTR_NO ASC" ).append("\n"); 

	}
}