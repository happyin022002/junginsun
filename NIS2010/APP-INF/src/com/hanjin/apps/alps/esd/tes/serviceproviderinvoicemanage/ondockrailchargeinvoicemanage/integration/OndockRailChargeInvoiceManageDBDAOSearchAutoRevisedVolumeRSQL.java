/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.16 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAutoRevisedVolume
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL").append("\n"); 
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
		query.append("SELECT  @[lgs_cost_cd]  			RVIS_LGS_COST_CD," ).append("\n"); 
		query.append("CNTR_NO 					RVIS_CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD 				RVIS_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TML_SO_CNTR_LIST_SEQ 		RVIS_TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("CNTR_STY_CD 				RVIS_CNTR_STY_CD," ).append("\n"); 
		query.append("'ON' 						RVIS_TML_INV_TP_CD," ).append("\n"); 
		query.append("'ON' 						RVIS_CALC_COST_GRP_CD," ).append("\n"); 
		query.append("'V'						RVIS_TML_RVIS_TP_CD," ).append("\n"); 
		query.append("BKG_NO 						RVIS_BKG_NO," ).append("\n"); 
		query.append("--BKG_NO_SPLIT 				RVIS_BKG_NO_SPLIT," ).append("\n"); 
		query.append("VSL_CD 						RVIS_VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO 					RVIS_SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD 					RVIS_SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(SUBSTR(@[lgs_cost_cd],1,2)," ).append("\n"); 
		query.append("'TP', DECODE(NVL(RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("'TM', DECODE(NVL(TML_RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("'SR', DECODE(NVL(STO_RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("'SV', DECODE(NVL(STV_RVIS_IND_FLG,'N'),'Y','1','0')) RVIS_IND_FLG" ).append("\n"); 
		query.append("FROM   TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("WHERE  VRFY_RSLT_IND_CD  	= 'CO'" ).append("\n"); 
		query.append("AND    TML_SO_OFC_CTY_CD 	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    TML_SO_SEQ   		= @[tml_so_seq]" ).append("\n"); 
		query.append("AND    NVL(CNTR_TPSZ_CD,'X') 	= NVL(@[cntr_tpsz_cd],'X')" ).append("\n"); 
		query.append("AND    NVL(IO_BND_CD,'X') 	= NVL(@[io_bnd_cd],'X')" ).append("\n"); 
		query.append("AND    NVL(DCGO_CLSS_CD,'X') 	= NVL(@[dcgo_clss_cd],'X')" ).append("\n"); 
		query.append("AND    DECODE(CNTR_STY_CD,'F','F','M') = SUBSTR(@[lgs_cost_cd],6,1)" ).append("\n"); 

	}
}