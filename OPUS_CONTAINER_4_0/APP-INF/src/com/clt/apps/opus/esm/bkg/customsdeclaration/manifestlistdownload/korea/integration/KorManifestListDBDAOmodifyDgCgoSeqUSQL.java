/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyDgCgoSeqUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.19 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOmodifyDgCgoSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * CNTR Cargo SEQ UPDATE
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyDgCgoSeqUSQL(){
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
		params.put("ib_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOmodifyDgCgoSeqUSQL").append("\n");
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
		query.append("UPDATE BKG_CSTMS_KR_DG_CGO" ).append("\n");
		query.append("SET CGO_SEQ_NO  = @[ib_seq]" ).append("\n");
		query.append("WHERE VSL_CD      = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND CNTR_SEQ    = @[cntr_seq]" ).append("\n");
		query.append("AND CNTR_NO     = @[cntr_no]" ).append("\n");
		query.append("AND IMDG_UN_NO  = @[imdg_un_no]" ).append("\n");
		query.append("AND IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n");
		query.append("AND BL_NO = @[bl_no]" ).append("\n");
		query.append("#if(${io_bnd_cd}=='I')" ).append("\n");
		query.append("AND POD_CD = @[pod_cd]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD IN ('I', 'T')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${io_bnd_cd}=='O')" ).append("\n");
		query.append("AND POL_CD = @[pol_cd]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD IN ('E', 'R')" ).append("\n");
		query.append("#end" ).append("\n");

	}
}