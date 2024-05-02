/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VVD SaDt
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[io_bnd_cd],'O', B.POL_VSL_CD,B.POD_VSL_CD)||DECODE(@[io_bnd_cd],'O', B.POL_SKD_VOY_NO,B.POD_SKD_VOY_NO)||DECODE(@[io_bnd_cd],'O', B.POL_SKD_DIR_CD,B.POD_SKD_DIR_CD) VVD," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'O', TO_CHAR(VPS_ETD_DT, 'YYYYMMDD'), TO_CHAR(VPS_ETA_DT, 'YYYYMMDD')) SAIL_ARR_DT" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A, MIGADM.MIG_INV_BKG_IF_MN B," ).append("\n"); 
		query.append("        (SELECT DECODE(@[io_bnd_cd], 'O', MAX(CLPT_IND_SEQ), MIN(CLPT_IND_SEQ)) CLPT_IND_SEQ" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD SKD, MIGADM.MIG_INV_BKG_IF_MN MN" ).append("\n"); 
		query.append("        WHERE SKD.VSL_CD = DECODE(@[io_bnd_cd],'O', MN.POL_VSL_CD,MN.POD_VSL_CD)" ).append("\n"); 
		query.append("        AND SKD.SKD_VOY_NO = DECODE(@[io_bnd_cd],'O', MN.POL_SKD_VOY_NO,MN.POD_SKD_VOY_NO)" ).append("\n"); 
		query.append("        AND SKD.SKD_DIR_CD =  DECODE(@[io_bnd_cd],'O', MN.POL_SKD_DIR_CD,MN.POD_SKD_DIR_CD)" ).append("\n"); 
		query.append("        AND SKD.VPS_PORT_CD =   @[port_cd]" ).append("\n"); 
		query.append("        AND MN.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND MN.BKG_SEQ = @[bkg_seq]) C" ).append("\n"); 
		query.append("WHERE A.VSL_CD = DECODE(@[io_bnd_cd], 'O', B.POL_VSL_CD,B.POD_VSL_CD)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = DECODE(@[io_bnd_cd], 'O', B.POL_SKD_VOY_NO,B.POD_SKD_VOY_NO)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD =  DECODE(@[io_bnd_cd], 'O', B.POL_SKD_DIR_CD,B.POD_SKD_DIR_CD)" ).append("\n"); 
		query.append("  AND A.VPS_PORT_CD =  @[port_cd]" ).append("\n"); 
		query.append("  AND A.CLPT_IND_SEQ = C.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND B.BKG_SEQ = @[bkg_seq]" ).append("\n"); 

	}
}