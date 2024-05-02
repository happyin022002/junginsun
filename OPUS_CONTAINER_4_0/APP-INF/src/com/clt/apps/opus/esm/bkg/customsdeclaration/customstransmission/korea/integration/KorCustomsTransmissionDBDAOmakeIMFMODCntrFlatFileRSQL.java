/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeIMFMODCntrFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.13
*@LastModifier :
*@LastVersion : 1.0
* 2010.07.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeIMFMODCntrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * IMFMOD CNTR Flat File
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeIMFMODCntrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_corr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_dat_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_dat_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_corr_id2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeIMFMODCntrFlatFileRSQL").append("\n");
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
		query.append("SELECT  BKG_SPCLCHAR_CONV_FNC(@[cntr_no],'Y')   ||'~'|| /*  Container No            */" ).append("\n");
		query.append("        @[cntr_tpsz_cd]           				||'~'|| /*  Container Type & Size   */" ).append("\n");
		query.append("        @[kr_cstms_corr_id]       				||'~'|| /*  Container Correction CD */" ).append("\n");
		query.append("        @[kr_cstms_corr_id2]      				||'~'|| /*  Container Correction TP */" ).append("\n");
		query.append("        @[pre_dat_ctnt]           				||'~'|| /*  Container 정정전 내역   */" ).append("\n");
		query.append("        @[new_dat_ctnt]           				||'~'|| /*  Container 정정후 내역   */" ).append("\n");
		query.append("        @[pck_qty]                				||'~'|| /*  Container Package Count */" ).append("\n");
		query.append("        @[pck_tp_cd]              				||'~'|| /*  Container Package Code  */" ).append("\n");
		query.append("        @[cntr_seal_no1]              				    /*  Seal No                 */" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

	}
}