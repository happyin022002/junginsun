/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyKcdTpByInVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOmodifyKcdTpByInVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Type 변경
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyKcdTpByInVVDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOmodifyKcdTpByInVVDUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("SET CSTMS_DECL_TP_CD  		=   @[cstms_decl_tp_cd]," ).append("\n"); 
		query.append("KR_CSTMS_BND_CD			=	CASE 	WHEN @[bkg_cgo_tp_cd] =  'P' AND @[cstms_decl_tp_cd] = 'T' THEN 'T'" ).append("\n"); 
		query.append("WHEN @[bkg_cgo_tp_cd] <> 'P' AND @[cstms_decl_tp_cd] = 'T' THEN 'R'" ).append("\n"); 
		query.append("WHEN @[bkg_cgo_tp_cd] <> 'P' AND @[cstms_decl_tp_cd] = 'I' THEN 'A'" ).append("\n"); 
		query.append("WHEN @[bkg_cgo_tp_cd] =  'P' AND @[cstms_decl_tp_cd] = 'I' THEN 'M'" ).append("\n"); 
		query.append("ELSE KR_CSTMS_BND_CD END" ).append("\n"); 
		query.append("WHERE 	BKG_NO          	=   @[bkg_no]" ).append("\n"); 
		query.append("AND 	CSTMS_DECL_TP_CD  	=   @[old_cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND 	DMST_PORT_CD      	=   @[port_cd]" ).append("\n"); 
		query.append("AND 	TRNS_SEQ          	=   @[trns_seq]" ).append("\n"); 
		query.append("AND 	NVL(IB_VSL_CD||IB_SKD_VOY_NO||IB_SKD_DIR_CD, ' ')    =   (   	SELECT  NVL(IB_VSL_CD||IB_SKD_VOY_NO||IB_SKD_DIR_CD, ' ')" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE   BKG_NO          	=   @[bkg_no]" ).append("\n"); 
		query.append("AND 	CSTMS_DECL_TP_CD    =   @[old_cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND 	DMST_PORT_CD        =   @[port_cd]" ).append("\n"); 
		query.append("AND 	TRNS_SEQ            =   @[trns_seq]" ).append("\n"); 
		query.append("AND 	CSTMS_BL_NO         =   @[bl_no])" ).append("\n"); 

	}
}