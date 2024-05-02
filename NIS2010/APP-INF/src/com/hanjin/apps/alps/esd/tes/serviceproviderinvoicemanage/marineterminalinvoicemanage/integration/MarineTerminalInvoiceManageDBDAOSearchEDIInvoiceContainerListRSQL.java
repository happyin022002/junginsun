/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDIInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceContainerListRSQL(){
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
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchEDIInvoiceContainerListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("C.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_STY_CD," ).append("\n"); 
		query.append("C.IO_BND_CD," ).append("\n"); 
		query.append("C.WRK_DT," ).append("\n"); 
		query.append("TES_GET_EDI_CNTR_TPSZ_CD_FNC(H.VNDR_SEQ,C.CNTR_TPSZ_CD,C.CNTR_NO) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H, TES_EDI_SO_CNTR_LIST C, TES_TML_SO_VVD_LIST V" ).append("\n"); 
		query.append("WHERE H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND ( (H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN ('MA')) OR H.TML_INV_TP_CD IN ('TM') )" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = C.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = C.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = V.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = V.TML_SO_SEQ" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN DECODE(C.IO_BND_CD,'I',SUBSTR(C.IB_VVD_CD,1,4),'O',SUBSTR(C.OB_VVD_CD,1,4))" ).append("\n"); 
		query.append("ELSE C.VSL_CD" ).append("\n"); 
		query.append("END = V.VSL_CD" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN DECODE(C.IO_BND_CD,'I',SUBSTR(C.IB_VVD_CD,5,4),'O',SUBSTR(C.OB_VVD_CD,5,4))" ).append("\n"); 
		query.append("ELSE C.SKD_VOY_NO" ).append("\n"); 
		query.append("END = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN DECODE(C.IO_BND_CD,'I',SUBSTR(C.IB_VVD_CD,9,1),'O',SUBSTR(C.OB_VVD_CD,9,1))" ).append("\n"); 
		query.append("ELSE C.SKD_DIR_CD" ).append("\n"); 
		query.append("END = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND V.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND C.IO_BND_CD = V.IO_BND_CD" ).append("\n"); 

	}
}