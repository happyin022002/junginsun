/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.09.15 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTES_FILE_IMP_TMP
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL").append("\n"); 
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
		query.append("SELECT  TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_SO_SEQ," ).append("\n"); 
		query.append("TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_STY_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("WRK_DT," ).append("\n"); 
		query.append("TO_CHAR(INV_GATE_IN_DT,'YYYYMMDD') INV_GATE_IN_DT," ).append("\n"); 
		query.append("TO_CHAR(INV_GATE_OUT_DT,'YYYYMMDD') INV_GATE_OUT_DT," ).append("\n"); 
		query.append("INV_VOL_QTY," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("VVD_CD," ).append("\n"); 
		query.append("TO_CHAR(ATB_DT,'YYYYMMDD') ATB_DT," ).append("\n"); 
		query.append("TO_CHAR(RCV_DT,'YYYYMMDD') RCV_DT," ).append("\n"); 
		query.append("FM_PRD_DT," ).append("\n"); 
		query.append("TO_PRD_DT," ).append("\n"); 
		query.append("FILE_IMP_SEQ" ).append("\n"); 
		query.append("FROM    TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("WHERE   tml_so_ofc_cty_cd = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND     tml_so_seq = @[tml_so_seq]" ).append("\n"); 

	}
}