/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchTjSrcNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchTjSrcNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchTjSrcNmRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchTjSrcNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchTjSrcNmRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[svr_id], 'KOR', DECODE(@[chg_cd], 'WHF', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', 'WHF')," ).append("\n"); 
		query.append("                                                     'CTT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', 'CTT')," ).append("\n"); 
		query.append("                                                     'TVA', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', 'VAT')," ).append("\n"); 
		query.append("                                                     'GST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("													 'SBC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("													 'KKC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("													 'STO', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'AST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'AU','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VDT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VTT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'VRT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'VST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'VCT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'VET', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'VFT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'VPT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR'))), " ).append("\n"); 
		query.append("                                                     'FAC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', 'SALAR')," ).append("\n"); 
		query.append("                                                            DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MDJ', 'NONRE'," ).append("\n"); 
		query.append("                                                                                         'MSO', 'NONRE'," ).append("\n"); 
		query.append("                                                                                         'MTP', 'NONRE', " ).append("\n"); 
		query.append("                                                                                         'MTH', DECODE(@[chg_cd], 'XXX', 'NONRE', 'OTHER')," ).append("\n"); 
		query.append("                                                                                         DECODE(@[rev_tp_cd], 'M', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MRD', '3RD', 'MRIAR'), 'SALAR')))," ).append("\n"); 
		query.append("                                   DECODE(@[chg_cd], 'TVA', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', 'VAT')," ).append("\n"); 
		query.append("                                                     'CTX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'JP','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'CDX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'JP','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'GST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("													 'SBC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("													 'KKC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("													 'STO', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'IN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'AST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'AU','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VDT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VTT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VRT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VCT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VET', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VFT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'VPT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', DECODE(SUBSTR(LOC_CD,1,2),'VN','VAT',DECODE(@[rev_tp_cd],'M','MRIAR','SALAR')))," ).append("\n"); 
		query.append("                                                     'FAC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', 'MRIAR', 'SALAR')," ).append("\n"); 
		query.append("                                                            DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MDJ', 'NONRE'," ).append("\n"); 
		query.append("                                                                                         'MSO', 'NONRE'," ).append("\n"); 
		query.append("                                                                                         'MTP', 'NONRE'," ).append("\n"); 
		query.append("                                                                                         'MTH', DECODE(@[chg_cd], 'XXX', 'NONRE', 'OTHER')," ).append("\n"); 
		query.append("                                                                                         DECODE(@[rev_tp_cd], 'M', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MRD', '3RD', 'MRIAR'), 'SALAR')))) TJ_SRC_NM" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}